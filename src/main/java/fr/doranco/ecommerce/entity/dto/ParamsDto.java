package fr.doranco.ecommerce.entity.dto;

public class ParamsDto {

	
	private String id;
	private String  cle_cryptage ;
	
	public ParamsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParamsDto(String id, String cle_cryptage) {
		super();
		this.id = id;
		this.cle_cryptage = cle_cryptage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCle_cryptage() {
		return cle_cryptage;
	}

	public void setCle_cryptage(String cle_cryptage) {
		this.cle_cryptage = cle_cryptage;
	}
	
	
}
