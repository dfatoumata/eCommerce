package fr.doranco.ecommerce.entity.dto;

public class ArticlePanierDto {
	
	private String id;
	private String article;
	private String quantite;
	private String utilisateur;
	
	public ArticlePanierDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticlePanierDto(String id, String article, String quantite, String utilisateur) {
		super();
		this.id = id;
		this.article = article;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
	}

	public ArticlePanierDto(String article, String quantite, String utilisateur) {
		super();
		this.article = article;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

}
