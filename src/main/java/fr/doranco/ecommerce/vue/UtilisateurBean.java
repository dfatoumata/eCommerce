package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.control.IUtilisateurMetier;
import fr.doranco.ecommerce.control.UtilisateurMetier;
import fr.doranco.ecommerce.entity.dto.UtilisateurDto;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.enums.TypeUtilisateur;
import fr.doranco.ecommerce.utils.Dates;


@ManagedBean(name = "userBean")
@SessionScoped
public class UtilisateurBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	
	@ManagedProperty(name = "genre", value = "")
	private String genre;
	
	@ManagedProperty(name = "nom", value = "")
	private String nom;
	
	@ManagedProperty(name = "prenom", value = "")
	private String prenom;
	
	@ManagedProperty(name = "email", value = "")
	private String email;
	
	@ManagedProperty(name = "password", value = "")
	private String password;
	
	@ManagedProperty(name = "confirmPassword", value = "")
	private String confirmPassword;
	
	@ManagedProperty(name = "telephone", value = "")
	private String telephone;
	
	@ManagedProperty(name = "dateNaissance", value = "")
	private String dateNaissance;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = " ";
	
	@ManagedProperty(name = "messageError", value = "")
	private String messageError = " ";

	public UtilisateurBean() {
	}
	
	public String ajouterUtilisateur() {

		if (!password.equals(confirmPassword)) {
			this.messageError = "Le mot de passe et le mot de passe de confirmation ne correspondent pas !\n";
			return "";
		}
		
		UtilisateurDto user = new UtilisateurDto();
		try {
			user.setDateNaissance(dateNaissance);
		} catch (Exception e) {
			this.messageError = "Erreur lors de la conversion de date de naissance !\n"
					+ e.getMessage();
			e.printStackTrace();
		}
		user.setGenre(genre);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setIsActif(true);
		user.setEmail(email);
		user.setPassword(confirmPassword);
		
		user.setTelephone(telephone);

		
		IUtilisateurMetier userMetier = new UtilisateurMetier();
		try {
			 userMetier.addUtilisateur(user);
				this.messageSuccess = "Utilisateur ajouté avec succès.";
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de l'ajout de l'utilisateur !\n"
					+ e.getMessage();
			e.printStackTrace();
		}
		this.userId = String.valueOf(user.getId());
		//this.id = addedUser.getId().toString();
		return "";
	}

	public String afficherUtilisateur(Utilisateur utilisateur) {
		
		this.userId = utilisateur.getId().toString();
		this.genre = utilisateur.getGenre();
		this.prenom = utilisateur.getPrenom();
		this.nom = utilisateur.getNom();
		this.email = utilisateur.getEmail();
		try {
			this.dateNaissance = Dates.convertDateUtilToString(utilisateur.getDateNaissance());
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de l'affichage de l'utilisateur sélectionné !\n"
					+ e.getMessage();
			e.printStackTrace();
		}
		this.telephone = utilisateur.getTelephone();		

		return "";
	}

	public String updateUtilisateur() {
		
		Utilisateur user = new Utilisateur();
		user.setId(Integer.valueOf(this.userId));
		user.setGenre(this.genre);
		user.setNom(this.nom);
		user.setPrenom(prenom);
		try {
			user.setDateNaissance(Dates.convertStringToDateUtil(dateNaissance));
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de la conversion de la date de naissance de l'utilisateur !\n"
					+ e.getMessage();
			e.printStackTrace();
		}
		
		user.setEmail(email);
		user.setPassword(password);
		user.setProfil(TypeUtilisateur.CLIENT.getTypeUtilisateur());
		user.setTelephone(telephone);
		
		IUtilisateurMetier userMetier = new UtilisateurMetier();
		try {
			userMetier.updateUtilisateur(user);
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de la mise à jour de l'utilisateur sélectionné !\n"
					+ e.getMessage();
			e.printStackTrace();
		}
		// this.id = this.userId.toString(); 
		return "";
	}

	public String supprimerUtilisateur(Utilisateur utilisateur) {
		
		IUtilisateurMetier userMetier = new UtilisateurMetier();
		try {
			userMetier.removeUtilisateur(utilisateur);
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de la suppression de l'utilisateur sélectionné !\n"
					+ e.getMessage();
			e.printStackTrace();
		}
		
		return "";
	}
	

	public List<Utilisateur> getUtilisateurs() {
		IUtilisateurMetier userMetier = new UtilisateurMetier();
		
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		try {
			users = userMetier.getUtilisateurs();
		} catch (Exception e) {
			messageError = "Erreur technique ! Veuillez réessayer plus tard.\n" + e.getMessage();
			e.printStackTrace();
		}
		
		return users;
	}

	public String seConnecter() {
		
		return "";
	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

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
