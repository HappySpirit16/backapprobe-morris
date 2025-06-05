package co.approbe.searchuser;



public class EconomicActivity {
	private String company;
	private CompanyActivity CompanyActivity;
	private String address;
	private String phone;
	private String position;
	

	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public CompanyActivity getCompanyActivity() {
		return CompanyActivity;
	}


	public void setCompanyActivity(CompanyActivity companyActivity) {
		CompanyActivity = companyActivity;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public EconomicActivity(String company, co.approbe.searchuser.EconomicActivity.CompanyActivity companyActivity,
			String address, String phone, String position) {
		super();
		this.company = company;
		CompanyActivity = companyActivity;
		this.address = address;
		this.phone = phone;
		this.position = position;
	}


	@Override
	public String toString() {
		return "EconomicActivity [company=" + company + ", CompanyActivity=" + CompanyActivity + ", address=" + address
				+ ", phone=" + phone + ", position=" + position + "]";
	}


	public EconomicActivity() {
		super();
	}


	public static class CompanyActivity{
		private int id;
		private String description;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "CompanyActivity [id=" + id + ", description=" + description + "]";
		}
		public CompanyActivity(int id, String description) {
			super();
			this.id = id;
			this.description = description;
		}
		public CompanyActivity() {
			super();
		}
	
	}
	
	

	
}
