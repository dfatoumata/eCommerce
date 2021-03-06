package fr.doranco.ecommerce.entity.dto;

import fr.doranco.ecommerce.entity.pojo.Utilisateur;

public class AdresseDto {
	private String id;
	private String numero;
	private String rue;
	private String ville;
	private String codePostal;
	private Utilisateur utilisateur;
	
	public AdresseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdresseDto(String id, String numero, String rue, String ville, String codePostal, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.utilisateur = utilisateur;
	}

	public AdresseDto(String numero, String rue, String ville, String codePostal, Utilisateur utilisateur) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.utilisateur = utilisateur;
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

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


}
