package co.approbe.award.lambda;

import java.util.List;

public class EconomicActivity {
	private String company;
	private CompanyActivity CompanyActivity;
	private City city;
	private String address;
	private String phone;
	private String position;
	private String pensionInformation;
	private Contractor contractor;
	private List<ConductorLabor> conductorLabor;
	private String sourceIncome;
	private Freelancer freelancer;
	
	
	
	
	
	@Override
	public String toString() {
		return "EconomicActivity [company=" + company + ", CompanyActivity=" + CompanyActivity + ", city=" + city
				+ ", address=" + address + ", phone=" + phone + ", position=" + position + ", pensionInformation="
				+ pensionInformation + ", contractor=" + contractor + ", conductorLabor=" + conductorLabor
				+ ", sourceIncome=" + sourceIncome + ", freelancer=" + freelancer + "]";
	}
	public CompanyActivity getCompanyActivity() {
		return CompanyActivity;
	}
	public void setCompanyActivity(CompanyActivity companyActivity) {
		CompanyActivity = companyActivity;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<ConductorLabor> getConductorLabor() {
		return conductorLabor;
	}
	public void setConductorLabor(List<ConductorLabor> conductorLabor) {
		this.conductorLabor = conductorLabor;
	}
	public String getPensionInformation() {
		return pensionInformation;
	}
	public void setPensionInformation(String pensionInformation) {
		this.pensionInformation = pensionInformation;
	}
	public Contractor getContractor() {
		return contractor;
	}
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}
	
	public String getSourceIncome() {
		return sourceIncome;
	}
	public void setSourceIncome(String sourceIncome) {
		this.sourceIncome = sourceIncome;
	}
	public Freelancer getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	
	public static class Contractor{
		private String name;
		private String nit;
		private String activity;
		private String codeCIIU;
		private int numberEmployees;
		private int activityYears;
		private String commercialAddress;
		private String commercialCity;
		private String commercialPhone;
		private String commercialProduct;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNit() {
			return nit;
		}
		public void setNit(String nit) {
			this.nit = nit;
		}
		public String getActivity() {
			return activity;
		}
		public void setActivity(String activity) {
			this.activity = activity;
		}
		public String getCodeCIIU() {
			return codeCIIU;
		}
		public void setCodeCIIU(String codeCIIU) {
			this.codeCIIU = codeCIIU;
		}
		public int getNumberEmployees() {
			return numberEmployees;
		}
		public void setNumberEmployees(int numberEmployees) {
			this.numberEmployees = numberEmployees;
		}
		public int getActivityYears() {
			return activityYears;
		}
		public void setActivityYears(int activityYears) {
			this.activityYears = activityYears;
		}
		public String getCommercialAddress() {
			return commercialAddress;
		}
		public void setCommercialAddress(String commercialAddress) {
			this.commercialAddress = commercialAddress;
		}
		public String getCommercialCity() {
			return commercialCity;
		}
		public void setCommercialCity(String commercialCity) {
			this.commercialCity = commercialCity;
		}
		public String getCommercialPhone() {
			return commercialPhone;
		}
		public void setCommercialPhone(String commercialPhone) {
			this.commercialPhone = commercialPhone;
		}
		public String getCommercialProduct() {
			return commercialProduct;
		}
		public void setCommercialProduct(String commercialProduct) {
			this.commercialProduct = commercialProduct;
		}
		@Override
		public String toString() {
			return "Contractor [name=" + name + ", nit=" + nit + ", activity=" + activity + ", codeCIIU=" + codeCIIU
					+ ", numberEmployees=" + numberEmployees + ", activityYears=" + activityYears
					+ ", commercialAddress=" + commercialAddress + ", commercialCity=" + commercialCity
					+ ", commercialPhone=" + commercialPhone + ", commercialProduct=" + commercialProduct + "]";
		}
		
		
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
		
		
	}
	public static class City{
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
			return "City [id=" + id + ", description=" + description + "]";
		}
		
	}
	
	public static class ConductorLabor{
		private String nameplate;
		private String companyVehicle;
		
		public String getNameplate() {
			return nameplate;
		}
		public void setNameplate(String nameplate) {
			this.nameplate = nameplate;
		}
		
		public String getNumberId() {
			return nameplate;
		}
		public void setNumberId(String nameplate) {
			this.nameplate = nameplate;
		}
		public String getCompanyVehicle() {
			return companyVehicle;
		}
		public void setCompanyVehicle(String companyVehicle) {
			this.companyVehicle = companyVehicle;
		}
	}
	
	public static class Freelancer{
		private String mainContractorName;
		private String nit;
		private ActivityContractor activityContractor;
		private String codeCIIU;
		private int employeeNumber;
		private int experienceYears;
		private String commercialAddress;
		private String commercialCity;
		private String commercialPhone;
		private String service;
		
		
		
		
		
		public ActivityContractor getActivityContractor() {
			return activityContractor;
		}
		public void setActivityContractor(ActivityContractor activityContractor) {
			this.activityContractor = activityContractor;
		}
		public String getNit() {
			return nit;
		}
		public void setNit(String nit) {
			this.nit = nit;
		}
		
		public String getMainContractorName() {
			return mainContractorName;
		}
		public void setMainContractorName(String mainContractorName) {
			this.mainContractorName = mainContractorName;
		}
		
		public String getCodeCIIU() {
			return codeCIIU;
		}
		public void setCodeCIIU(String codeCIIU) {
			this.codeCIIU = codeCIIU;
		}
		public int getEmployeeNumber() {
			return employeeNumber;
		}
		public void setEmployeeNumber(int employeeNumber) {
			this.employeeNumber = employeeNumber;
		}
		public int getExperienceYears() {
			return experienceYears;
		}
		public void setExperienceYears(int experienceYears) {
			this.experienceYears = experienceYears;
		}
		public String getCommercialAddress() {
			return commercialAddress;
		}
		public void setCommercialAddress(String commercialAddress) {
			this.commercialAddress = commercialAddress;
		}
		public String getCommercialCity() {
			return commercialCity;
		}
		public void setCommercialCity(String commercialCity) {
			this.commercialCity = commercialCity;
		}
		public String getCommercialPhone() {
			return commercialPhone;
		}
		public void setCommercialPhone(String commercialPhone) {
			this.commercialPhone = commercialPhone;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		
		public static class ActivityContractor {
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
			

		}
		
		
		@Override
		public String toString() {
			return "Freelancer [mainContractorName=" + mainContractorName + ", nit=" + nit + ", activityContractor="
					+ activityContractor + ", codeCIIU=" + codeCIIU + ", employeeNumber=" + employeeNumber
					+ ", experienceYears=" + experienceYears + ", commercialAddress=" + commercialAddress
					+ ", commercialCity=" + commercialCity + ", commercialPhone=" + commercialPhone + ", service="
					+ service + "]";
		}
		
		
		
		
	}
	
	
}
