package fr.doranco.ecommerce.entity.dto;

public class CartePaiementDto {

	private String id;
	private String nomProprietaire;
	private String prenomProprietaire;
	private String numero;
	private String dateFinValidite;
	private String cryptogramme;
	
	public CartePaiementDto() {
	}

	public CartePaiementDto(String id, String nomProprietaire, String prenomProprietaire, String numero,
			String dateFinValidite, String cryptogramme) {
		super();
		this.id = id;
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateFinValidite = dateFinValidite;
		this.cryptogramme = cryptogramme;
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

	public void setDateFinValidite(String dateValidite) {
		this.dateFinValidite = dateValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}
	
	
}