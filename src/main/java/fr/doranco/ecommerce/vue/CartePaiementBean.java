package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.metier.IUtilisateurMetier;
import fr.doranco.ecommerce.metier.UtilisateurMetier;

public class CartePaiementBean {

	

	private String id;
	private String nomProprietaire;
	private String prenomProprietaire;
	private String numero;
	private String dateFinValidite;
	private String cryptogramme;
	@ManagedBean(name = "CartePaiementBean")
	@SessionScoped
	public class AjouterAdresseBean implements Serializable {

		private static final long serialVersionUID = 1L;

		@ManagedProperty(name = "id", value = "")
		private String id;
		
	    @ManagedProperty(name = "nomProprietaire", value = "")
	    private String nomProprietaire;
	    
	    @ManagedProperty(name = "prenomProprietaire", value = "")
	    private String prenomProprietaire;
	    
	    @ManagedProperty(name = "numero", value = "")
		private String numero;
	    
	    @ManagedProperty(name = "dateFinValidite", value = "")
		private String dateFinValidite;
	    
	    @ManagedProperty(name = "cryptogramme", value = "")
		private String cryptogramme;

		public AjouterAdresseBean() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNomProprietaire() {
			return nomProprietaire;
		}

		public void setNomProprietaire(String nomProprietaire) {
			this.nomProprietaire = nomProprietaire;
		}

		public String getPrenomProprietaire() {
			return prenomProprietaire;
		}

		public void setPrenomProprietaire(String prenomProprietaire) {
			this.prenomProprietaire = prenomProprietaire;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getDateFinValidite() {
			return dateFinValidite;
		}

		public void setDateFinValidite(String dateFinValidite) {
			this.dateFinValidite = dateFinValidite;
		}

		public String getCryptogramme() {
			return cryptogramme;
		}

		public void setCryptogramme(String cryptogramme) {
			this.cryptogramme = cryptogramme;
		}
		
		@ManagedProperty(name = "messageSuccess", value = "")
		private String messageSuccess = " ";

		@ManagedProperty(name = "messageError", value = "")
		private String messageError = " ";

		
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

		public String ajouterCartePaiement(CartePaiement cartePaiement) {
			Utilisateur user = LoginBean.getConnectedUser();
			user.getCartePaiements().add(cartePaiement);

			IUtilisateurMetier utilisateurMetier = new UtilisateurMetier();
			try {
				utilisateurMetier.updateUtilisateur(user);
				
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
			return "";
		}
	    
	    
	    
	    
	    
	}
	    
}



