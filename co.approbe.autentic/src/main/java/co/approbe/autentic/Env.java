package co.approbe.autentic;

public class Env {
	 public static final String AUTH_AUDIENCE = System.getenv("AUTH_AUDIENCE") == null ? "" : System.getenv("AUTH_AUDIENCE");
	 public static final String AUTH_GRANTTYPE = System.getenv("AUTH_GRANTTYPE") == null ? "" : System.getenv("AUTH_GRANTTYPE");
	 public static final String AUTH_CLIENTID = System.getenv("AUTH_CLIENTID") == null ? "" : System.getenv("AUTH_CLIENTID");
	 public static final String AUTH_CLIENTSECRET = System.getenv("AUTH_CLIENTSECRET") == null ? "" : System.getenv("AUTH_CLIENTSECRET");
	 public static final String URL_TOKEN = System.getenv("URL_TOKEN") == null ? "" : System.getenv("URL_TOKEN");
	 public static final String URL_FIRMA = System.getenv("URL_FIRMA") == null ? "" : System.getenv("URL_FIRMA");
	 public static final String URL_OTP = System.getenv("URL_OTP") == null ? "" : System.getenv("URL_OTP");
	 public static final String AUTH_PASS = System.getenv("AUTH_PASS") == null ? "" : System.getenv("AUTH_PASS");
}
