package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adresse", catalog = "ecommerce_db")
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	@Column(name = "id")
	private Integer id;

	@NotNull
	@Column(name = "numero", length = 4, nullable = false)
	private Integer numero;

	@NotNull
	@NotEmpty
	@Column(name = "rue", length = 45, nullable = false)
	private String rue;
	
	
	@NotNull
	@NotEmpty
	@Column(name = "ville", length = 20, nullable = false)
	private String ville;

	@NotNull
	@NotEmpty
	@Column(name = "code_postal", length = 5, nullable = false)
	private String codePostal;

	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;

	@OneToOne
	@JoinColumn(name = "adresse_facturation_id", nullable = false)
	private Commande commande;
	
	
	public Adresse() {

	}

	public Adresse(Integer numero, String rue, String ville, String codePostal) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}


	public Adresse(Integer id, @NotNull Integer numero, @NotNull @NotEmpty String rue, @NotNull @NotEmpty String ville,
			@NotNull @NotEmpty String codePostal) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	
	public Adresse(Integer id, @NotNull Integer numero, @NotNull @NotEmpty String rue, @NotNull @NotEmpty String ville,
			@NotNull @NotEmpty String codePostal, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.utilisateur = utilisateur;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostal="
				+ codePostal + "]";
	}

}
