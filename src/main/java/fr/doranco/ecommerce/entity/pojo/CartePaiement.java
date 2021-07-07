package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fr.doranco.ecommerce.vue.LoginBean;

@Entity
@Table(name = "carte_paiement", catalog = "ecommerce_db")
public class CartePaiement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "nom_proprietaire", length = 25, nullable = false)
	private String nomProprietaire;
	
	@NotNull
	@Column(name = "prenom_proprietaire", length = 25, nullable = false)
	private String prenomProprietaire;
	
	@NotNull
	@Column(name = "numero", length = 25, nullable = false)
	private byte[] numero;

	@NotNull
	@Column(name = "date_Fin_Validite", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFinValidite;
	
	@NotNull
	@Column(name = "cryptogramme", length = 40, nullable = false)
	private byte[] cryptogramme;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;
	

	
	public CartePaiement() {
		System.out.println("CartePaiement");

	}

	public CartePaiement(Integer id, @NotNull String nomProprietaire, @NotNull String prenomProprietaire,
			@NotNull byte[] numero, @NotNull Date dateFinValidite, @NotNull byte[] cryptogramme,
			Utilisateur utilisateur) {
		this.id = id;
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateFinValidite = dateFinValidite;
		this.cryptogramme = cryptogramme;
		this.utilisateur = utilisateur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public byte[] getNumero() {
		return numero;
	}

	public void setNumero(byte[] numero) {
		this.numero = numero;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public byte[] getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", nomProprietaire=" + nomProprietaire + ", prenomProprietaire="
				+ prenomProprietaire + ", numero=" + numero + ", dateFinValidite=" + dateFinValidite + ", cryptogramme="
				+ cryptogramme + ", utilisateur=" + utilisateur + "]";
	}

	
}
