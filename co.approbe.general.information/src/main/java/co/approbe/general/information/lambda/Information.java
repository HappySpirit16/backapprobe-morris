package co.approbe.general.information.lambda;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import co.approbe.general.information.lambda.GeneralInformation.CausalDeclined;


@DynamoDBTable(tableName = "tableGeneralInformation")
public class Information {
	@DynamoDBHashKey
	private int id;
	@DynamoDBAttribute
	private List<Identification> identification;
	@DynamoDBAttribute
	private List<CreditUse> creditUse;	
	@DynamoDBAttribute
	private List<FeesMonthly> feesMonthly;
	@DynamoDBAttribute
	private List<CompanyActivity> companyActivity;	
	@DynamoDBAttribute
	private List<PensionCompany> pensionCompany;
	@DynamoDBAttribute
	private List<ActivityContractor> activityContractor;
	@DynamoDBAttribute
	private List<Department> department;
	@DynamoDBAttribute
	private List<City> city;
	@DynamoDBAttribute
	private List<CivilStatus> civilStatus;
	@DynamoDBAttribute
	private List<Career> career;	
	@DynamoDBAttribute
	private List<Relationship> relationship;
	@DynamoDBAttribute
	private List<ProductType> producType;
	@DynamoDBAttribute
	private List<Entity> entity;
	@DynamoDBAttribute
	private List<Occupation> occupation;
	@DynamoDBAttribute
	private List<Assets> assets;
	@DynamoDBAttribute
	private List<Notice> notice;
	@DynamoDBAttribute
	private List<Profession> profession;
	@DynamoDBAttribute
	private List<ListaBancos> listaBancos;
	private List<CausalDeclined> causalDeclined;
	@DynamoDBAttribute
	private double yearRate;
	@DynamoDBAttribute
	private double montlyRate;
	@DynamoDBAttribute
	private int age;

	public double getYearRate() {
		return yearRate;
	}




	public double getMontlyRate() {
		return montlyRate;
	}




	public void setYearRate(double yearRate) {
		this.yearRate = yearRate;
	}




	public void setMontlyRate(double montlyRate) {
		this.montlyRate = montlyRate;
	}




	public List<ListaBancos> getListaBancos() {
		return listaBancos;
	}




	public void setListaBancos(List<ListaBancos> listaBancos) {
		this.listaBancos = listaBancos;
	}




	public List<CausalDeclined> getCausalDeclined() {
		return causalDeclined;
	}




	public void setCausalDeclined(List<CausalDeclined> causalDeclined) {
		this.causalDeclined = causalDeclined;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public Information() {
		super();
	}


	public Information(int id, List<Identification> identification, List<CreditUse> creditUse,
			List<FeesMonthly> feesMonthly, List<CompanyActivity> companyActivity, List<PensionCompany> pensionCompany,
			List<ActivityContractor> activityContractor, List<Department> department, List<City> city,
			List<CivilStatus> civilStatus, List<Career> career, List<Relationship> relationship,
			List<ProductType> producType, List<Entity> entity, List<Occupation> occupation, List<Assets> assets,
			List<Notice> notice, List<Profession> profession, List<ListaBancos> listaBancos,double montlyRate,double yearRate,
			List<CausalDeclined> causalDeclined,int age) {
		super();
		this.id = id;
		this.identification = identification;
		this.creditUse = creditUse;
		this.feesMonthly = feesMonthly;
		this.companyActivity = companyActivity;
		this.pensionCompany = pensionCompany;
		this.activityContractor = activityContractor;
		this.department = department;
		this.city = city;
		this.civilStatus = civilStatus;
		this.career = career;
		this.relationship = relationship;
		this.producType = producType;
		this.entity = entity;
		this.occupation = occupation;
		this.assets = assets;
		this.notice = notice;
		this.profession = profession;
		this.listaBancos = listaBancos;
		this.yearRate=yearRate;
		this.montlyRate=montlyRate;
		this.causalDeclined=causalDeclined;
		this.age=age; 
	}




	public List<Profession> getProfession() {
		return profession;
	}
	public void setProfession(List<Profession> profession) {
		this.profession = profession;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Identification> getIdentification() {
		return identification;
	}

	public void setIdentification(List<Identification> identification) {
		this.identification = identification;
	}

	public List<CreditUse> getCreditUse() {
		return creditUse;
	}

	public void setCreditUse(List<CreditUse> creditUse) {
		this.creditUse = creditUse;
	}

	public List<FeesMonthly> getFeesMonthly() {
		return feesMonthly;
	}

	public void setFeesMonthly(List<FeesMonthly> feesMonthly) {
		this.feesMonthly = feesMonthly;
	}

	public List<CompanyActivity> getCompanyActivity() {
		return companyActivity;
	}

	public void setCompanyActivity(List<CompanyActivity> companyActivity) {
		this.companyActivity = companyActivity;
	}

	public List<PensionCompany> getPensionCompany() {
		return pensionCompany;
	}

	public void setPensionCompany(List<PensionCompany> pensionCompany) {
		this.pensionCompany = pensionCompany;
	}

	public List<ActivityContractor> getActivityContractor() {
		return activityContractor;
	}

	public void setActivityContractor(List<ActivityContractor> activityContractor) {
		this.activityContractor = activityContractor;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public List<CivilStatus> getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(List<CivilStatus> civilStatus) {
		this.civilStatus = civilStatus;
	}

	public List<Career> getCareer() {
		return career;
	}

	public void setCareer(List<Career> career) {
		this.career = career;
	}

	public List<Relationship> getRelationship() {
		return relationship;
	}

	public void setRelationship(List<Relationship> relationship) {
		this.relationship = relationship;
	}

	public List<ProductType> getProducType() {
		return producType;
	}

	public void setProducType(List<ProductType> producType) {
		this.producType = producType;
	}

	public List<Entity> getEntity() {
		return entity;
	}

	public void setEntity(List<Entity> entity) {
		this.entity = entity;
	}
	

	public List<Occupation> getOccupation() {
		return occupation;
	}




	public void setOccupation(List<Occupation> occupation) {
		this.occupation = occupation;
	}




	public List<Assets> getAssets() {
		return assets;
	}




	public void setAssets(List<Assets> assets) {
		this.assets = assets;
	}
	
	

	public List<Notice> getNotice() {
		return notice;
	}




	public void setNotice(List<Notice> notice) {
		this.notice = notice;
	}



	@DynamoDBDocument
	public static class Notice {
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

	@DynamoDBDocument
	public static class Assets {
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
	
	@DynamoDBDocument
	public static class Occupation {
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
	


	@DynamoDBDocument
	public static class Entity {
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

	@DynamoDBDocument
	public static class ProductType {
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

	@DynamoDBDocument
	public static class Relationship {
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

	@DynamoDBDocument
	public static class Career {
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

	@DynamoDBDocument
	public static class CivilStatus {
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

	@DynamoDBDocument
	public static class City {
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

	@DynamoDBDocument
	public static class Department {
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

	@DynamoDBDocument
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

	@DynamoDBDocument
	public static class PensionCompany {
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

	@DynamoDBDocument
	public static class CompanyActivity {
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

	@DynamoDBDocument
	public static class FeesMonthly {
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

	@DynamoDBDocument
	public static class CreditUse {
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
	
	@DynamoDBDocument
	public static class ListaBancos {
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

	@DynamoDBDocument
	public static class Profession {
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

	@DynamoDBDocument
	public static class Identification {
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
	@DynamoDBDocument
	public static class CausalDeclined {
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
	
}
