package fr.doranco.ecommerce.entity.dto;

public class UtilisateurDto {

	private String id;
	private String genre;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String telephone;
	private String dateNaissance;
	private String profil;
	
	public UtilisateurDto() {
	}

	
	public UtilisateurDto(String genre, String nom, String prenom, String email, String password, String dateNaissance, String profil) {
		this.profil = profil;
		this.genre = genre;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
	}


	public UtilisateurDto(String genre, String id, String nom, String prenom, String email, String password, String dateNaissance, String profil) {
		this.profil = profil;
		this.genre = genre;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
	}


	public UtilisateurDto(String genre, String id, String nom, String prenom, String email, String password, String telephone,
			String dateNaissance, String profil) {
		this.profil = profil;
		this.genre = genre;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getProfil() {
		return profil;
	}


	public void setProfil(String profil) {
		this.profil = profil;
	}
	
	
	
}
