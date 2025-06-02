package co.approbe.autentic;

public class Appearance {
	private String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Appearance(String page) {
		super();
		this.page = page;
	}

	@Override
	public String toString() {
		return "{\"page\":\"" + page + "\"}";
	}

	public Appearance() {
		super();
	}
	

}
