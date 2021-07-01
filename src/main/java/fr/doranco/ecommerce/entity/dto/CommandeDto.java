package fr.doranco.ecommerce.entity.dto;

public class CommandeDto {
	
	private String id;
	private String numero;
	private String dateCreation;
	private String dateLivraison;
	private String totalRemise;
	private String fraisExpedition;
	private String totalGeneral;
	private String adresseFacturation;
	private String adresseLivraison;
	private String cartePaiementDefaut;
	private String utilisateur;
	private String lignesCommande ;
	
	public CommandeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandeDto(String id, String numero, String dateCreation, String dateLivraison, String totalRemise,
			String fraisExpedition, String totalGeneral, String adresseFacturation, String adresseLivraison,
			String cartePaiementDefaut, String utilisateur, String lignesCommande) {
		super();
		this.id = id;
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
		this.cartePaiementDefaut = cartePaiementDefaut;
		this.utilisateur = utilisateur;
		this.lignesCommande = lignesCommande;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(String totalRemise) {
		this.totalRemise = totalRemise;
	}

	public String getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(String fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public String getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(String totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public String getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(String adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public String getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}

	public void setCartePaiementDefaut(String cartePaiementDefaut) {
		this.cartePaiementDefaut = cartePaiementDefaut;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(String lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
	
	
	
	
}
