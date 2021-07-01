package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.IArticleMetier;
import fr.doranco.ecommerce.metier.IUtilisateurMetier;
import fr.doranco.ecommerce.metier.UtilisateurMetier;

@ManagedBean(name = "gestionAchatBean")
@SessionScoped
public class GestionAchatBean implements Serializable {

	private static final long serialVersionUID = 1L;

//	@ManagedProperty(name = "id", value = "")
//	private String id;
//	@ManagedProperty(name = "nom", value = "")
//	private String nom;
//	@ManagedProperty(name = "description", value = "")
//	private String description;
//	@ManagedProperty(name = "prix", value = "")
//	private String prix;
//	@ManagedProperty(name = "remise", value = "")
//	private String remise;
//	@ManagedProperty(name = "stock", value = "")
//	private String stock;
//	@ManagedProperty(name = "isVendable", value = "")
//	private String isVendable;

//	@ManagedProperty(name = "articleId", value = "")
//	private String articleId;
//	@ManagedProperty(name = "articleNom", value = "")
//	private String articleNom;
//	@ManagedProperty(name = "articleDescription", value = "")
//	private String articleDescription;
//	@ManagedProperty(name = "articlePrix", value = "")
//	private String articlePrix;
//	@ManagedProperty(name = "articleRemise", value = "")
//	private String articleRemise;
//	@ManagedProperty(name = "articleStock", value = "")
//	private String articleStock;
//	@ManagedProperty(name = "articleIsVendable", value = "")
//	private String articleIsVendable;

//	@ManagedProperty(name = "userId", value = "")
//	private String userId;
//	
//	@ManagedProperty(name = "genre", value = "")
//	private String genre;
//	
//	@ManagedProperty(name = "nom", value = "")
//	private String nom;
//	
//	@ManagedProperty(name = "prenom", value = "")
//	private String prenom;
//	
//	@ManagedProperty(name = "email", value = "")
//	private String email;
//	
//	@ManagedProperty(name = "password", value = "")
//	private String password;
//	
//	@ManagedProperty(name = "confirmPassword", value = "")
//	private String confirmPassword;
//	
//	@ManagedProperty(name = "telephone", value = "")
//	private String telephone;
//	
//	@ManagedProperty(name = "dateNaissance", value = "")
//	private String dateNaissance;
	
//	@ManagedProperty(name = "quantite", value = "")
//	private String quantite = " ";
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = " ";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = " ";

	public GestionAchatBean() {
	}

	String ajouterAuPanier(Article article, String quantite) {

		Integer qte = Integer.valueOf(quantite);
		Utilisateur user = LoginBean.getConnectedUser();
		ArticlePanier articlePanier = new ArticlePanier();
		articlePanier.setArticle(article);
		articlePanier.setQuantite(qte);
		if (user.getPanier().contains(articlePanier)) {
			Integer oldQuantite = user.getPanier().get(user.getPanier().indexOf(articlePanier)).getQuantite();
			user.getPanier().get(user.getPanier().indexOf(articlePanier)).setQuantite(qte + oldQuantite);
		}
		user.getPanier().add(articlePanier);

		IUtilisateurMetier utilisateurMetier = new UtilisateurMetier();
		try {
			utilisateurMetier.updateUtilisateur(user);
			// afficher un popup indiquant que l'article a été ajouté au panier
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}

	public List<Article> getArticles() {

		IArticleMetier articleMetier = new ArticleMetier();

		List<Article> articles = new ArrayList<Article>();
		try {
			articles = articleMetier.getArticles();
		} catch (Exception e) {
			messageError = "Erreur technique ! Veuillez réessayer plus tard.\n" + e.getMessage();
			e.printStackTrace();
		}

		return articles;
	}

//	public String ajouterAuPanier() {
//		
//	}

//	public String updateUtilisateur() {
//		
//		Utilisateur user = new Utilisateur();
//		user.setId(Integer.valueOf(this.userId));
//		user.setGenre(this.genre);
//		user.setNom(this.nom);
//		user.setPrenom(prenom);
//		try {
//			user.setDateNaissance(Dates.convertStringToDateUtil(dateNaissance));
//		} catch (Exception e) {
//			this.messageError = "Erreur technique lors de la conversion de la date de naissance de l'utilisateur !\n"
//					+ e.getMessage();
//			e.printStackTrace();
//		}
//		
//		user.setEmail(email);
//		user.setPassword(password);
//		user.setProfil(TypeUtilisateur.CLIENT.getTypeUtilisateur());
//		user.setTelephone(telephone);
//		
//		IUtilisateurMetier userMetier = new UtilisateurMetier();
//		try {
//			userMetier.updateUtilisateur(user);
//		} catch (Exception e) {
//			this.messageError = "Erreur technique lors de la mise à jour de l'utilisateur sélectionné !\n"
//					+ e.getMessage();
//			e.printStackTrace();
//		}
//		// this.id = this.userId.toString(); 
//		return "";
//	}

//	public String supprimerUtilisateur(Utilisateur utilisateur) {
//		
//		IUtilisateurMetier userMetier = new UtilisateurMetier();
//		try {
//			userMetier.removeUtilisateur(utilisateur);
//		} catch (Exception e) {
//			this.messageError = "Erreur technique lors de la suppression de l'utilisateur sélectionné !\n"
//					+ e.getMessage();
//			e.printStackTrace();
//		}
//		
//		return "";
//	}
//	

	public String seConnecter() {

		return "";
	}

//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getGenre() {
//		return genre;
//	}
//
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
//
//	public String getNom() {
//		return nom;
//	}
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//	public String getPrenom() {
//		return prenom;
//	}
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}
//
//	public String getTelephone() {
//		return telephone;
//	}
//
//	public void setTelephone(String telephone) {
//		this.telephone = telephone;
//	}
//
//	public String getDateNaissance() {
//		return dateNaissance;
//	}
//
//	public void setDateNaissance(String dateNaissance) {
//		this.dateNaissance = dateNaissance;
//	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
