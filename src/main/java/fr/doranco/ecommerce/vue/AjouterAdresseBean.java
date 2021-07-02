package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.metier.AdresseMetier;
import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.IAdresseMetier;
import fr.doranco.ecommerce.metier.IArticleMetier;
import fr.doranco.ecommerce.metier.IUtilisateurMetier;
import fr.doranco.ecommerce.metier.UtilisateurMetier;

@ManagedBean(name = "ajouterAdresseBean")
@SessionScoped
public class AjouterAdresseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "id", value = "")
	private String id;
    @ManagedProperty(name = "numero", value = "")
    private String numero;
    @ManagedProperty(name = "rue", value = "")
    private String rue;
    @ManagedProperty(name = "ville", value = "")
	private String ville;
    
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getId() {
		return id;
	}

	@ManagedProperty(name = "code_postal", value = "")
    private String code_postal;

	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = " ";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = " ";

	public AjouterAdresseBean() {
	}

	public String ajouterAdresse(Adresse adresse) {
		Utilisateur user = LoginBean.getConnectedUser();
		user.getAdresses().add(adresse);

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

	public List<Adresse> getAdresses() {

		
		IAdresseMetier adresseMetier = new AdresseMetier();
		
		Utilisateur user = LoginBean.getConnectedUser();
		
		Integer idUser= user.getId();
		
		List<Adresse> adresses = new ArrayList<Adresse>();
		try {
			adresses = adresseMetier.getAdressesUtilisateur(idUser);
		} catch (Exception e) {
			messageError = "Erreur technique ! Veuillez réessayer plus tard.\n" + e.getMessage();
			e.printStackTrace();
		}

		return adresses;
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
