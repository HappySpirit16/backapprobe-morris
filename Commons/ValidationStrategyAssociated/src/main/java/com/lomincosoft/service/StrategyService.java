package com.lomincosoft.service;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.lomincosoft.commonsDto.CustomerDto;
import com.lomincosoft.commonsDto.ValidationStrategyDto;
import com.lomincosoft.commonsModel.Customer;
import com.lomincosoft.dto.TransactionStatusDto;
import com.lomincosoft.model.Partner;
import com.lomincosoft.model.UserEmail;

public class StrategyService {

	AmazonDynamoDB db;
	DynamoDBMapper mapper;

	public static final String ERROR_MAXAMMOUNT = "ERROR_MAXAMMOUNT";
	private static final String ERROR_MINAMMOUNT = "ERROR_MINAMMOUNT";
	public static final String CREDIT_IN_PROCESS = "CREDIT_IN_PROCESS";
	public static final String PARTNER_NO_FOUNT = "PARTNER_NO_FOUNT";
	public static final String ERROR_DATA_USER = "ERROR_DATA_USER";
	public static final String MSG_NO_FOUNT = "No tienes activo este servicio";

	private static final String ERROR_PARTNER_DOESNT_EXIST = "ERROR_PARTNER_DOESNT_EXIST";

	HttpClient client = HttpClient.newHttpClient();
	HttpResponse<String> response;
	String messageBodyReconocerOrEvidente = "";
	ValidationStrategyDto validationStrategy;

	public static final String OK = "OK";

	public StrategyService(AmazonDynamoDB pDb, DynamoDBMapper pMapper, ValidationStrategyDto pValidationStrategy) {
		db = pDb;
		mapper = pMapper;
		validationStrategy = pValidationStrategy;
	}

	// partner BNPL
	public ValidationStrategyDto getStrategy(CustomerDto pCustomer, Context context) {
		context.getLogger().log("Entra a strategy");
		Customer wCustomerDB = new Customer(pCustomer);
		saveCustomer(wCustomerDB, context);
		context.getLogger().log("se Guarda: " + wCustomerDB);
		wCustomerDB.setStatusDate(wCustomerDB.getFechaSolicitud());
		
		boolean bloqueo=bloqueo(pCustomer, context); 

		if (pCustomer.getClient() == null || pCustomer.getClient().equals("")) {
			pCustomer.setClient("APR");
			context.getLogger().log("partner: " + pCustomer.getClient());
		}
		Partner wPartner = mapper.load(Partner.class, pCustomer.getClient());
		

		if (wPartner == null) {
			validationStrategy.setValidationStrategy(ERROR_PARTNER_DOESNT_EXIST);
			wCustomerDB.setCausalRechazo("Partner no existe");
			context.getLogger().log("ERROR: Partner no existe");
		} else if (wPartner.getMinAmmount() > pCustomer.getAmmount()) {
			validationStrategy.setValidationStrategy(ERROR_MINAMMOUNT);
			wCustomerDB.setCausalRechazo("Error monto minimo");
			context.getLogger().log("ERROR: Error monto minimo");
		} else if (wPartner.getMaxAmmount() < pCustomer.getAmmount()) {
			validationStrategy.setValidationStrategy(ERROR_MAXAMMOUNT);
			wCustomerDB.setCausalRechazo("Error monto maximo");
			context.getLogger().log("ERROR: Error monto maximo");
		} else if (wPartner.getActiveUrlBNPL() == 0) {
			validationStrategy.setValidationStrategy(PARTNER_NO_FOUNT);
			validationStrategy.setUrl(MSG_NO_FOUNT);
			wCustomerDB.setCausalRechazo("Partner no tiene activo Integracion");
			context.getLogger().log("ERROR: Partner no tiene activo Integracion");
		} else if(bloqueo) {
			validationStrategy.setValidationStrategy(ERROR_DATA_USER);
			wCustomerDB.setCausalRechazo("No coincide con datos de UserEmail");
			context.getLogger().log("ERROR: No coincide con datos de UserEmail");
		}else {
			validationStrategy.setValidationStrategy(OK);
			validationStrategy.setId(wCustomerDB.getId());
			validationStrategy.setFechaCreacion(wCustomerDB.getFechaSolicitud());
			validationStrategy.setUrl(wPartner.getUrlBNPL() + wCustomerDB.getId());
			wCustomerDB.setStatusCredit(CREDIT_IN_PROCESS);
			wCustomerDB.setChannel("BNPL");
		}
		mapper.save(wCustomerDB);
		context.getLogger().log(validationStrategy.getUrl());
		context.getLogger().log("queda guardado como: " + wCustomerDB.toString());
		return validationStrategy;
	}

	// partner billeteras

	public ValidationStrategyDto getStrategyWallet(CustomerDto pCustomer, Context context) {
		context.getLogger().log("Entra a strategy Wallet");
		Customer wCustomerDB = new Customer(pCustomer);
		saveCustomer(wCustomerDB, context);
		context.getLogger().log("se Guarda: " + wCustomerDB);
		wCustomerDB.setStatusDate(wCustomerDB.getFechaSolicitud());
		boolean bloqueo=bloqueo(pCustomer, context); 

		if (pCustomer.getClient() == null || pCustomer.getClient().equals("")) {
			pCustomer.setClient("APR");
		}
		Partner wPartner = mapper.load(Partner.class, pCustomer.getClient());

		if (wPartner == null) {
			validationStrategy.setValidationStrategy(ERROR_PARTNER_DOESNT_EXIST);
			wCustomerDB.setCausalRechazo("Partner no existe");
		} else if (wPartner.getActiveUrlWallet() == 0) {
			validationStrategy.setValidationStrategy(PARTNER_NO_FOUNT);
			validationStrategy.setUrl(MSG_NO_FOUNT);
			wCustomerDB.setCausalRechazo("Partner no tiene activo Integracion");
		}else if(bloqueo) {
			validationStrategy.setValidationStrategy(ERROR_DATA_USER);
			wCustomerDB.setCausalRechazo("No coincide con datos de UserEmail");
		} else {
			validationStrategy.setValidationStrategy(OK);
			validationStrategy.setId(wCustomerDB.getId());
			validationStrategy.setFechaCreacion(wCustomerDB.getFechaSolicitud());
			validationStrategy.setUrl(wPartner.getUrlWallet() + wCustomerDB.getId());
			wCustomerDB.setStatusCredit(CREDIT_IN_PROCESS);
			wCustomerDB.setChannel("WALLET");
		}
		mapper.save(wCustomerDB);
		context.getLogger().log(validationStrategy.getUrl());
		context.getLogger().log("queda guardado como: " + wCustomerDB.toString());
		return validationStrategy;
	}

	public void saveCustomer(Customer pCustomer, Context pContext) {

		mapper.save(pCustomer);
	}

	public TransactionStatusDto transactioStatus(CustomerDto pCustomer, Context context) {
		Customer wCustomerDB = searchCustomer(pCustomer, context);
		TransactionStatusDto transaction = new TransactionStatusDto();
		if (wCustomerDB != null) {
			transaction.setAmmount(String.valueOf(wCustomerDB.getAmmount()));
			transaction.setStatus(wCustomerDB.getStatusCredit());
			transaction.setCreationDate(wCustomerDB.getFechaSolicitud());
			transaction.setId(wCustomerDB.getId());
			transaction.setStatusDate(wCustomerDB.getStatusDate());
			if (wCustomerDB.getStatusCredit().equals("CREDIT_APPROVED")) {
				transaction.setAccountingDate(wCustomerDB.getAccountingDate());
				transaction.setCyclo(wCustomerDB.getCycle());
			}

		} else {
			transaction = null;
		}
		return transaction;
	}

	public Customer searchCustomer(CustomerDto pCustomer, Context pContext) {
		Customer customerDB = new Customer();
		customerDB = mapper.load(Customer.class, pCustomer.getId());

		return customerDB;
	}

	public boolean bloqueo(CustomerDto pCustomer, Context context) {
		boolean bloqueo = true;

		UserEmail userEmail = new UserEmail();
		try {
			userEmail = mapper.load(UserEmail.class, pCustomer.getEmailFormulario());
			if (userEmail != null) {
				context.getLogger().log("User Information: " + userEmail.toString());
				if (userEmail.getCellphone().equals(pCustomer.getCelularFormulario())
						&& userEmail.getNumberId().equals(pCustomer.getIdentificacion())
						&& userEmail.getBlocking() == 0) {
					bloqueo = false;
				}
			}else{
				bloqueo = false;
			}
		} catch (Exception e) {
			context.getLogger().log("ERROR: " + e);
		}

		return bloqueo;

	}

}
