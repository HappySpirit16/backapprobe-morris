package co.approbe.powwi;

public class Env {
	 public static final String AUTH_HOST = System.getenv("AUTH_HOST") == null ? "" : System.getenv("AUTH_HOST");
	 public static final String AUTH_REGION = System.getenv("AUTH_REGION") == null ? "" : System.getenv("AUTH_REGION");
	 public static final String AUTH_PATH = System.getenv("AUTH_PATH") == null ? "" : System.getenv("AUTH_PATH");
	 public static final String AUTH_ACCESS_KEY = System.getenv("AUTH_ACCESS_KEY") == null ? "" : System.getenv("AUTH_ACCESS_KEY");
	 public static final String AUTH_SECRET_KEY = System.getenv("AUTH_SECRET_KEY") == null ? "" : System.getenv("AUTH_SECRET_KEY");
	 public static final String AUTH_USERNAME = System.getenv("AUTH_USERNAME") == null ? "" : System.getenv("AUTH_USERNAME");
	 public static final String URL_AWS = System.getenv("URL_AWS") == null ? "" : System.getenv("URL_AWS");
	 public static final String URL_GCP = System.getenv("URL_GCP") == null ? "" : System.getenv("URL_GCP");
	 
	 
}
