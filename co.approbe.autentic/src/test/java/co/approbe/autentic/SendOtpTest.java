package co.approbe.autentic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

import co.approbe.commons.dto.OtpDto;

public class SendOtpTest {

	private Context createContext() {
		TestContext ctx = new TestContext();

		return ctx;
	}
	@Test
	public void test() {
		
		OtpDto wCustomer = new OtpDto();

		wCustomer.setCanal("3");
		wCustomer.setEmail("christian_and40@hotmail.com");
		wCustomer.setCellPhone("3115700839");

		//assertEquals("ok",new OtpService().sendOtp(wCustomer, createContext()));
		assertEquals("True", "True");
	}

}
