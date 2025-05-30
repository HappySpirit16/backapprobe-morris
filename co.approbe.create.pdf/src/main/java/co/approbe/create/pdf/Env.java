package co.approbe.create.pdf;

public class Env {
	 public static final String EMAIL_PROD = System.getenv("EMAIL_PROD") == null ? "" : System.getenv("EMAIL_PROD");
	 public static final String BUCKETS3 = System.getenv("BUCKETS3") == null ? "" : System.getenv("BUCKETS3");
}
