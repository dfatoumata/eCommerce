package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.CartePaiementMetier;
import fr.doranco.ecommerce.metier.IArticleMetier;
import fr.doranco.ecommerce.metier.ICartePaiementMetier;
import fr.doranco.ecommerce.metier.IUtilisateurMetier;
import fr.doranco.ecommerce.metier.UtilisateurMetier;



	@ManagedBean(name = "CartePaiementBean")
	@SessionScoped
	public class CartePaiementBean {
	
	

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
	    
		Utilisateur user = LoginBean.getConnectedUser();
	  
	

		public CartePaiementBean() {
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

		public String ajouterCartePaiement() {

			
			CartePaiementDto carte = new CartePaiementDto();
			carte.setNomProprietaire(nomProprietaire);
			carte.setPrenomProprietaire(prenomProprietaire);
			carte.setNumero(numero);
			carte.setCryptogramme(cryptogramme);
			carte.setDateFinValidite(dateFinValidite);
			carte.setUtilisateur(user);
			
		ICartePaiementMetier carteM = new CartePaiementMetier();
		
		try {
			carteM.addCartePaiement(carte, user.getId());
			this.messageSuccess = "Carte ajouté avec succès.";
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de l'ajout de la carte de paiement !\n";
			e.printStackTrace();
		}
			
		
			return "";
		}
	    
	    
		public List<CartePaiement> getCartePaiement() {

//			ICartePaiementMetier carteMetier = new CartePaiementMetier();
//
//			List<CartePaiement> cartes = new ArrayList<CartePaiement>();
//			try {
//				cartes = carteMetier.getCartes();
//			} catch (Exception e) {
//				messageError = "Erreur technique ! Veuillez réessayer plus tard.\n" + e.getMessage();
//				e.printStackTrace();
//			}

			return null;
		}
	    
	}



