package fr.doranco.ecommerce.entity.dto;

public class ArticleDto {
	
	private String id;
	private String nom;
	private String description;
	private String prix;
	private String remise;
	private String stock;
	private String isVendable;
	
	public ArticleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleDto(String id, String nom, String description, String prix, String remise, String stock,
			String isVendable) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
	}

	public ArticleDto(String nom, String description, String prix, String remise, String stock, String isVendable) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getIsVendable() {
		return isVendable;
	}

	public void setIsVendable(String isVendable) {
		this.isVendable = isVendable;
	}
	
	
	

}
