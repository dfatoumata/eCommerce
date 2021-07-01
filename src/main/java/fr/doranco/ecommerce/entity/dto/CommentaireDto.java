package fr.doranco.ecommerce.entity.dto;

public class CommentaireDto {
	
	private String id;
	private String texte;
	private String note ;
	private String article;
	private String utilisateur;
	
	
	public CommentaireDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CommentaireDto(String id, String texte, String note, String article, String utilisateur) {
		super();
		this.id = id;
		this.texte = texte;
		this.note = note;
		this.article = article;
		this.utilisateur = utilisateur;
	}


	public CommentaireDto(String texte, String note, String article, String utilisateur) {
		super();
		this.texte = texte;
		this.note = note;
		this.article = article;
		this.utilisateur = utilisateur;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTexte() {
		return texte;
	}


	public void setTexte(String texte) {
		this.texte = texte;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getArticle() {
		return article;
	}


	public void setArticle(String article) {
		this.article = article;
	}


	public String getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

}
