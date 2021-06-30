package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer.Param;

import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.dao.IUtilisateurDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;
import fr.doranco.ecommerce.utils.CryptageDesPbeBlowfish;

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

	public String  seConnecter() {
		
		final IUtilisateurDao userDao = new UtilisateurDao();
		Utilisateur user = userDao.getUtilisateurByEmail(email);
		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
		Params params = new Params();
		
		SecretKey cleCryptage = new SecretKeySpec(params.getCleCrypatage(), algorithm);
		byte[] passwordCrypte = user.getPassword();
		String passwordDecrypte = CryptageDesPbeBlowfish.decrypt(algorithm, passwordCrypte, cleCryptage);
		
		if (motDePasse.equals(passwordDecrypte)) {
			
		}
		
		
		//return password.equals(passwordDecrypte);
		
		//...r�cup�rer les email et password saisis
		//...appeler getUtilisateurByEmail(...)
		//......si utilisateur inexistant, alors afficher "Email et/ou mot de passe incorrect(s), veuillez r�essayer"
		//...comparer les mots de passe
		//......si mot de passe incorrect, alors afficher "Email et/ou mot de passe incorrect(s), veuillez r�essayer"
		//...Si correct => redirection � la page de "gestion des achats" si c'est un client, � la page
		//.......de "gestion admin" si c'est un admin, et � la page "gestion des artciles" si c'est c'est un magasinier
		// en affichant (pour les 3 cas) le message de succ�s de connexion.
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
