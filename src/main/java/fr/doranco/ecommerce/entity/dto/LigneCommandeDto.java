package fr.doranco.ecommerce.entity.dto;

public class LigneCommandeDto {

	private String  id;
	private String  quantite;
	private String  prixUnitaire;
	private String  remiseArticle;
	private String commande;
	private String article ;
	
	public LigneCommandeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommandeDto(String id, String quantite, String prixUnitaire, String remiseArticle, String commande,
			String article) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}

	public LigneCommandeDto(String quantite, String prixUnitaire, String remiseArticle, String commande,
			String article) {
		super();
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(String prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(String remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public String getCommande() {
		return commande;
	}

	public void setCommande(String commande) {
		this.commande = commande;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
	
	
}
