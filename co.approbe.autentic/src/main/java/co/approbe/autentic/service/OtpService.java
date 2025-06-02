package co.approbe.autentic.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import co.approbe.autentic.Env;
import co.approbe.autentic.ResultOtp;
import co.approbe.commons.dto.OtpDto;


import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OtpService {

	

	public String sendOtp(OtpDto pOtpDto,Context pContext) {
		Map<String, String> values = new HashMap<String, String>();
		String bodyAut = "";
		ObjectMapper objectMapperAut = new ObjectMapper();
		ResultOtp resultOtp;
		
		values.put("typeSending", pOtpDto.getCanal());
		values.put("destinationMail",pOtpDto.getEmail());
		values.put("phoneNumber", pOtpDto.getCellPhone());
		
		try {
			bodyAut = objectMapperAut.writeValueAsString(values);
		} catch (JsonProcessingException e3) {
			pContext.getLogger().log(e3.getMessage());
		}
		try {
			pContext.getLogger().log("datos salida generarOtp: " + values);
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Env.URL_OTP + "/v2/autentic/generateotp"))//prod
					.setHeader("Content-Type", "application/json")
					.setHeader("Authorization", Env.AUTH_PASS)
					.POST(HttpRequest.BodyPublishers.ofString(bodyAut)).build();
			HttpResponse<String> responseAut;
			responseAut = client.send(request, HttpResponse.BodyHandlers.ofString());
			String response = responseAut.body();
			resultOtp = new Gson().fromJson(response, ResultOtp.class);
			pContext.getLogger().log("Send OTP Response:"+response+" RestultOTP: "+ resultOtp.toString());
			return "ok";
		} catch (Exception e) {
			pContext.getLogger().log(e.getMessage());
			return "fail";
		}
	}
	
	
}
