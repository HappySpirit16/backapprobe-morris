package co.approbe.userinformation;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request, String> {
	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);

	@Override
	public String handleRequest(Request request, Context context) {

		UserInformation information = new UserInformation();

		/// busco la informacion de la cedula
		information = mapper.load(UserInformation.class, request.getNumberId());
		switch (request.getHttpMethod()) {
		case "BASIC":
			information.setNames(request.getNames());
			information.setCellphone(request.getCellphone());
			information.setLastName(request.getLastName());
			mapper.save(information);
			return "datos basicos actualizados";

		case "LABORAL":
			information.setCompanyName(request.getCompanyName());
			information.setCompanyActivity(request.getCompanyActivity());
			information.setPosition(request.getPosition());
			information.setCompanyPhone(request.getCompanyPhone());
			information.setCompanyAddress(request.getCompanyAddress());
			information.setCompanySeniority(request.getCompanySeniority());

			mapper.save(information);
			return "Informacion Laboral actualizada";

		case "GERENERALAWARD":
			System.out.println("1");
			information.getGeneralInformationAward()
					.setDepartment(request.getGeneralInformationAward().getDepartment());
			information.getGeneralInformationAward().setCity(request.getGeneralInformationAward().getCity());
			information.getGeneralInformationAward().setBirth(request.getGeneralInformationAward().getBirth());
			information.getGeneralInformationAward()
					.setMaritalStatus(request.getGeneralInformationAward().getMaritalStatus());
			information.getGeneralInformationAward()
					.setDepartmentResidence(request.getGeneralInformationAward().getDepartmentResidence());
			information.getGeneralInformationAward().setAddress(request.getGeneralInformationAward().getAddress());
			information.getGeneralInformationAward().setHomePhone(request.getGeneralInformationAward().getHomePhone());
			System.out.println("2");
			mapper.save(information);
			return "Informacion Laboral award actualizada";

		case "GENERAL":
			information.getGeneralInformation().getDepartment()
					.setId(request.getGeneralInformation().getDepartment().getId());
			information.getGeneralInformation().getDepartment()
					.setDepartment(request.getGeneralInformation().getDepartment().getDepartment());
			information.getGeneralInformation().getCity().setId(request.getGeneralInformation().getCity().getId());
			information.getGeneralInformation().getCity().setCity(request.getGeneralInformation().getCity().getCity());
			information.getGeneralInformation().setBirth(request.getGeneralInformation().getBirth());
			information.getGeneralInformation().getMaritalStatus()
					.setStatus(request.getGeneralInformation().getMaritalStatus().getStatus());
			information.getGeneralInformation().getDepartmentResidence().getDepartment()
					.setId(request.getGeneralInformation().getDepartmentResidence().getDepartment().getId());
			information.getGeneralInformation().getDepartmentResidence().getDepartment().setDepartment(
					request.getGeneralInformation().getDepartmentResidence().getDepartment().getDepartment());
			information.getGeneralInformation().setAddress(request.getGeneralInformation().getAddress());
			information.getGeneralInformation().setStratum(request.getGeneralInformation().getStratum());
			information.getGeneralInformation().getHomeType()
					.setHome(request.getGeneralInformation().getHomeType().getHome());
			information.getGeneralInformation().setHomePhone(request.getGeneralInformation().getHomePhone());
			information.getGeneralInformation().setPersonCharge(request.getGeneralInformation().getPersonCharge());
			information.getGeneralInformation().setNumberChildren(request.getGeneralInformation().getNumberChildren());

			mapper.save(information);
			return "Informacion General actualizada";

		case "REFERENCE":
			information.getReference().setPersonalName(request.getReference().getPersonalName());
			information.getReference().setPersonalLastname(request.getReference().getPersonalLastname());
			information.getReference().setPersonalCellphone(request.getReference().getPersonalCellphone());
			information.getReference().setFamiliarName(request.getReference().getFamiliarName());
			information.getReference().setFamiliarLastname(request.getReference().getFamiliarLastname());
			information.getReference().setFamiliarCellphone(request.getReference().getFamiliarCellphone());
			information.getReference().setRelationship(request.getReference().getRelationship());
			mapper.save(information);
			return "Informacion de referencias guardada";

		case "FINANCIERA":
			// total ingresos mensuales
			information.getFinancialInformation().setTotalIncome(request.getFinancialInformation().getTotalIncome());

			// total egresos mensuales
			information.getFinancialInformation().setExpense(request.getFinancialInformation().getExpense());

			// total activos
			information.getFinancialInformation().setAssets(request.getFinancialInformation().getAssets());

			// total pasivos
			information.getFinancialInformation().setLiability(request.getFinancialInformation().getLiability());

			// total patrimonio
			information.getFinancialInformation()
					.setTotalNetworth(request.getFinancialInformation().getTotalNetworth());

			mapper.save(information);

			return "Informacion fianaciera guardada";
		case "FINANCIERAAWARD":

			information.setFinancialInformationAward(request.getFinancialInformationAward());
			mapper.save(information);
			mapper.save(information);
			return "Informacion fianaciera award guardada";

		}

		return null;
	}

}
