package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "commande", catalog = "ecommerce_db")
@NamedQueries({
	@NamedQuery(name = "Commande.findAll", query = "FROM Commande c"),
	@NamedQuery(name = "Commande.findById", query = "FROM Commande c WHERE c.id =:id")
})
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id	// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
	@Column(name = "id")
	private Integer id ;
	
	@NotNull
	@Column(name = "numero", nullable = false)
	private Integer numero ;
	
	@NotNull
	@Column(name = "date_creation", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCreation ;
	
	@NotNull
	@Column(name = "date_livraison", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateLivraison ;

	@NotNull
	@Column(name = "total_remise", nullable = false)
	private double totalRemise ;
	
	@NotNull
	@Column(name = "frais_expedition", nullable = false)
	private double fraisExpedition ;
	
	@NotNull
	@Column(name = "total_general", nullable = false)
	private double totalGeneral ;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="adresse_facturation_id")
	private Adresse adresseFacturation;	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="adresse_livraison_id")
	private Adresse adresseLivraison;	
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LigneCommande> lignesCommande;
	
	public Commande() {
		this.lignesCommande = new ArrayList<LigneCommande>();
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



	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}


	
}
