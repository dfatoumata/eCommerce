package fr.doranco.ecommerce.entity.dto;

public class CategorieDto {

	
	private String id;
	private String nom;
	private String remise;
	private String photo;
	private String articles;
	
	
	public CategorieDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CategorieDto(String id, String nom, String remise, String photo, String articles) {
		super();
		this.id = id;
		this.nom = nom;
		this.remise = remise;
		this.photo = photo;
		this.articles = articles;
	}


	public CategorieDto(String nom, String remise, String photo, String articles) {
		super();
		this.nom = nom;
		this.remise = remise;
		this.photo = photo;
		this.articles = articles;
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


	public String getRemise() {
		return remise;
	}


	public void setRemise(String remise) {
		this.remise = remise;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getArticles() {
		return articles;
	}


	public void setArticles(String articles) {
		this.articles = articles;
	}
	
	
	
}
