package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.dto.AdresseDto;
import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.entity.pojo.LigneCommande;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.metier.AdresseMetier;
import fr.doranco.ecommerce.metier.IAdresseMetier;

@ManagedBean(name = "ajouterAdresseBean")
@SessionScoped
public class AjouterAdresseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	@ManagedProperty(name = "numero", value = "")
	private String numero;

	@ManagedProperty(name = "rue", value = "")
	private String rue;

	@ManagedProperty(name = "ville", value = "")
	private String ville;

	@ManagedProperty(name = "code_postal", value = "")
	private String code_postal;

	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = " ";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = " ";

	Utilisateur user = LoginBean.getConnectedUser();

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

	public AjouterAdresseBean() {
	}

	public String ajouterAdresse() {

		AdresseDto adresse = new AdresseDto();
		adresse.setNumero(numero);
		adresse.setRue(rue);
		adresse.setVille(ville);
		adresse.setCodePostal(code_postal);
		adresse.setUtilisateur(user);
		
		Adresse adresseN = new Adresse();
		
		adresseN.setNumero(Integer.parseInt(adresse.getNumero()));
		adresseN.setRue(adresse.getRue().toUpperCase());
		adresseN.setVille(adresse.getVille().toUpperCase());
		adresseN.setCodePostal(adresse.getCodePostal());
		
		
		
		adresseN.setUtilisateur(user);

		IAdresseMetier adresseMetier = new AdresseMetier();

		try {
			
			adresseMetier.addAdresse(adresse, user.getId());

			Commande Commande = new Commande();
			Commande.setAdresseFacturation()
			user.getCommandes();
			for (Commande Commande  : user.getCommandes()) {
				Commande.setAdresseFacturation(adresse);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}

	public List<Adresse> getAdresses() {

		IAdresseMetier adresseMetier = new AdresseMetier();

		Utilisateur user = LoginBean.getConnectedUser();

		Integer idUser = user.getId();

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

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setId(String id) {
		this.id = id;
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
