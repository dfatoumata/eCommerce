package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.dao.IUtilisateurDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;
import fr.doranco.ecommerce.utils.CryptageDesPbeBlowfish;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Utilisateur connectedUser;
	
	@ManagedProperty(name = "email", value = "")
	private String email;
	
	@ManagedProperty(name = "password", value = "")
	private String password;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private String messageError;

	public LoginBean() {
	}

	public String  seConnecter() {
		
		final IUtilisateurDao userDao = new UtilisateurDao();
		Utilisateur user = null;
		try {
			user = userDao.getUtilisateurByEmail(email);
		} catch (Exception e) {
			messageError = "Email et ou mot de passe incorrect, veuillez reesayer";
			e.printStackTrace();
		}
		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();

		ParamsDao paramsDao = new ParamsDao();
		Params params = null;
		try {
			params = paramsDao.get(Params.class, 1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		SecretKey cleCryptage = new SecretKeySpec(params.getCleCrypatage(), algorithm);
		byte[] passwordCrypte = user.getPassword();
		String passwordDecrypte = null;
		try {
			passwordDecrypte = CryptageDesPbeBlowfish.decrypt(algorithm, passwordCrypte, cleCryptage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (password.equals(passwordDecrypte) && user.getIsActif()) {

			messageSuccess = "Connexion reussie";
			this.connectedUser = user;
			return user.getProfil().equals("C") ? "gestion-achats"
					: user.getProfil().equals("M") ? "gestion-articles" : "gestion-admin";
			
//			if (user.getProfil().equals("C")) {
//				messageSuccess = "Connexion reussie";
//				return "gestion-achats";
//			}
//			if (user.getProfil().equals("M")) {
//				messageSuccess = "Connexion reussie";
//				return "gestion-articles";
//			}
//			if (user.getProfil().equals("A")) {
//				messageSuccess = "Connexion reussie";
//				return "gestion-admin";
//			}
		}else {
			messageError = "Email et ou mot de passe incorrect, veuillez reesayer ou creez un compte";
		}
		
		return "";
	}
	
	public static Utilisateur getConnectedUser() {
		return connectedUser;
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
