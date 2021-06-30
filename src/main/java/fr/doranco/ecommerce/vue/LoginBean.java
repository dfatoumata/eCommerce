package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "email", value = "")
	private String email;
	
	@ManagedProperty(name = "password", value = "")
	private String motDePasse;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private String messageError;

	public LoginBean() {
	}

	public String seConnecter() {
		
		//...récupérer les email et password saisis
		//...appeler getUtilisateurByEmail(...)
		//......si utilisateur inexistant, alors afficher "Email et/ou mot de passe incorrect(s), veuillez réessayer"
		//...comparer les mots de passe
		//......si mot de passe incorrect, alors afficher "Email et/ou mot de passe incorrect(s), veuillez réessayer"
		//...Si correct => redirection à la page de "gestion des achats" si c'est un client, à la page
		//.......de "gestion admin" si c'est un admin, et à la page "gestion des artciles" si c'est c'est un magasinier
		// en affichant (pour les 3 cas) le message de succès de connexion.
		return "";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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
