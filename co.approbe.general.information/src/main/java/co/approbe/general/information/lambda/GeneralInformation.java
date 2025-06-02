package co.approbe.general.information.lambda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "tableGeneralInformation")
public class GeneralInformation {
	
	@DynamoDBHashKey
	private int id;	
	private List<Identification> identification;	
	private List<CreditUse> creditUse;	
	private List<FeesMonthly> feesMonthly;	
	private List<CompanyActivity> companyActivity;	
	private List<PensionCompany> pensionCompany;	
	private List<ActivityContractor> activityContractor;	
	private List<Department> department;	
	private List<City> city;	
	private List<CivilStatus> civilStatus;	
	private List<Career> career;	
	private List<Relationship> relationship;	
	private List<ProductType> producType;	
	private List<Entity> entity;
	private List<Profession> profession;
	private List<ListaBancos> listaBancos;
	private List<CausalDeclined> causalDeclined;
	@DynamoDBAttribute
	private int active;
	@DynamoDBAttribute
	private double yearRate;
	@DynamoDBAttribute
	private double montlyRate;
	@DynamoDBAttribute
	private String description;
	LocalDateTime dateTime = LocalDateTime.now();
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	@DynamoDBAttribute
	private String dateSave = dateTime.format(dtformat);
	

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

	public GeneralInformation() {
		super();
	}


	public GeneralInformation(int id, List<Identification> identification, List<CreditUse> creditUse,
			List<FeesMonthly> feesMonthly, List<CompanyActivity> companyActivity, List<PensionCompany> pensionCompany,
			List<ActivityContractor> activityContractor, List<Department> department, List<City> city,
			List<CivilStatus> civilStatus, List<Career> career, List<Relationship> relationship,
			List<ProductType> producType, List<Entity> entity, List<Profession> profession,
			List<ListaBancos> listaBancos, int active, String description, String dateSave,double montlyRate,double yearRate,
			List<CausalDeclined> causalDeclined) {
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
		this.profession = profession;
		this.listaBancos = listaBancos;
		this.active = active;
		this.description = description;
		this.dateSave = dateSave;
		this.yearRate=yearRate;
		this.montlyRate=montlyRate;
		this.causalDeclined=causalDeclined;
	}

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
	@DynamoDBAttribute
	public List<Identification> getIdentification() {
		return identification;
	}

	public void setIdentification(List<Identification> identification) {
		this.identification = identification;
	}
	@DynamoDBAttribute
	public List<CreditUse> getCreditUse() {
		return creditUse;
	}

	public void setCreditUse(List<CreditUse> creditUse) {
		this.creditUse = creditUse;
	}
	@DynamoDBAttribute
	public List<FeesMonthly> getFeesMonthly() {
		return feesMonthly;
	}

	public void setFeesMonthly(List<FeesMonthly> feesMonthly) {
		this.feesMonthly = feesMonthly;
	}
	@DynamoDBAttribute
	public List<CompanyActivity> getCompanyActivity() {
		return companyActivity;
	}

	public void setCompanyActivity(List<CompanyActivity> companyActivity) {
		this.companyActivity = companyActivity;
	}
	@DynamoDBAttribute
	public List<PensionCompany> getPensionCompany() {
		return pensionCompany;
	}

	public void setPensionCompany(List<PensionCompany> pensionCompany) {
		this.pensionCompany = pensionCompany;
	}
	@DynamoDBAttribute
	public List<ActivityContractor> getActivityContractor() {
		return activityContractor;
	}

	public void setActivityContractor(List<ActivityContractor> activityContractor) {
		this.activityContractor = activityContractor;
	}
	@DynamoDBAttribute
	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	@DynamoDBAttribute
	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}
	@DynamoDBAttribute
	public List<CivilStatus> getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(List<CivilStatus> civilStatus) {
		this.civilStatus = civilStatus;
	}
	@DynamoDBAttribute
	public List<Career> getCareer() {
		return career;
	}

	public void setCareer(List<Career> career) {
		this.career = career;
	}
	@DynamoDBAttribute
	public List<Relationship> getRelationship() {
		return relationship;
	}

	public void setRelationship(List<Relationship> relationship) {
		this.relationship = relationship;
	}
	@DynamoDBAttribute
	public List<ProductType> getProducType() {
		return producType;
	}

	public void setProducType(List<ProductType> producType) {
		this.producType = producType;
	}
	@DynamoDBAttribute
	public List<Entity> getEntity() {
		return entity;
	}

	public void setEntity(List<Entity> entity) {
		this.entity = entity;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public DateTimeFormatter getDtformat() {
		return dtformat;
	}

	public void setDtformat(DateTimeFormatter dtformat) {
		this.dtformat = dtformat;
	}

	public String getDateSave() {
		return dateSave;
	}

	public void setDateSave(String dateSave) {
		this.dateSave = dateSave;
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
