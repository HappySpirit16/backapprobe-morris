package co.approbe.autentic;

public class EnvTest {
	 public static final String AUTH_AUDIENCE = System.getenv("AUTH_AUDIENCE") == null ? "" : System.getenv("AUTH_AUDIENCE");
	 public static final String AUTH_GRANTTYPE = System.getenv("AUTH_GRANTTYPE") == null ? "" : System.getenv("AUTH_GRANTTYPE");
	 public static final String AUTH_CLIENTID = System.getenv("AUTH_CLIENTID") == null ? "" : System.getenv("AUTH_CLIENTID");
	 public static final String AUTH_CLIENTSECRET = System.getenv("AUTH_CLIENTSECRET") == null ? "" : System.getenv("AUTH_CLIENTSECRET");
	 public static final String URL_TOKEN = System.getenv("URL_TOKEN") == null ? "" : System.getenv("URL_TOKEN");
	 public static final String URL_FIRMA = System.getenv("URL_FIRMA") == null ? "" : System.getenv("URL_FIRMA");
	 public static final String URL_OTP = "https://j4dmk2yez8.execute-api.us-east-1.amazonaws.com/test";
	 public static final String AUTH_PASS = "a2Vubnkuc2lsdmFAYXBwcm9iZS5jb3xBcHByb2JlIC0gRHV2ZXJhUUF8OTAxNDk5MDM2NXxUaHUgSnVuIDE1IDE5OjQ4OjE2IFVUQyAyMDIzfFFVQjNqdy91RHBBbnk3bUs3TVo4Y2c9PXw";
}
