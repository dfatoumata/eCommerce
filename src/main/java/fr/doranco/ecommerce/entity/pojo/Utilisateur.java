package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "utilisateur", catalog = "ecommerce_db")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM Utilisateur u"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email =: email")
})
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "genre", length = 25, nullable = false)
	private String genre;
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;

	@NotNull
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@NotNull
	@Column(name = "isActif", nullable = false)	
	private Boolean isActif;
	
	@NotNull
	@NotEmpty
	@Column(name = "profil", length = 1, nullable = false)	
	private String profil;

	@NotNull
	@NotEmpty
	@Column(name = "email", length = 40, nullable = false, unique = true)
	private String email;
	
	@NotNull
	@NotEmpty
	@Column(name = "password", length = 40, nullable = false)
	private String password;
	
	@Column(name = "telephone", length = 40)	
	private String telephone;

	
	
	
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Adresse> adresses;

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Commande> commandes;
	
	public Utilisateur() {
		adresses = new HashSet<Adresse>();
		commandes = new HashSet<Commande>();
	}
	
	public Utilisateur(@NotEmpty String genre, @NotEmpty String nom, @NotEmpty String prenom,
			@NotNull Date dateNaissance, @NotNull Boolean isActif, @NotEmpty String profil, @NotEmpty String email,
			@NotEmpty String password) {
		this.genre = genre;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		adresses = new HashSet<Adresse>();	
		commandes = new HashSet<Commande>();
	}

	public Utilisateur(@NotEmpty String genre, @NotEmpty String nom, @NotEmpty String prenom,
			@NotNull Date dateNaissance, @NotNull Boolean isActif, @NotEmpty String profil, @NotEmpty String email,
			@NotEmpty String password, String telephone) {
		this.genre = genre;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		adresses = new HashSet<Adresse>();	
		commandes = new HashSet<Commande>();
	}

	public Utilisateur(Integer id, @NotEmpty String genre, @NotEmpty String nom, @NotEmpty String prenom,
			@NotNull Date dateNaissance, @NotNull Boolean isActif, @NotEmpty String profil, @NotEmpty String email,
			@NotEmpty String password, String telephone) {
		this.id = id;
		this.genre = genre;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		adresses = new HashSet<Adresse>();	
		commandes = new HashSet<Commande>();
	}

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", genre=" + genre + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", isActif=" + isActif + ", profil=" + profil + ", email=" + email + ", password="
				+ password + ", telephone=" + telephone + "]";
	}




}
