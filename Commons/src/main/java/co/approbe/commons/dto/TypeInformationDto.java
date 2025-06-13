package co.approbe.commons.dto;

public class TypeInformationDto {
	private String id;
	private String description;
	
	public TypeInformationDto() {
	}

	public TypeInformationDto(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "{\"id\":\"" + id + "\", \"description\":\"" + description + "\"}";
	}
	
}
