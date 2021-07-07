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
	private Double totalRemise ;
	
	@NotNull
	@Column(name = "frais_expedition", nullable = false)
	private Double fraisExpedition ;
	
	@NotNull
	@Column(name = "total_general", nullable = false)
	private Double totalGeneral ;
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="adresse_facturation_id" )
	private Adresse adresseFacturation;	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="adresse_livraison_id")
	private Adresse adresseLivraison;	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="carte_paiement_id")
	private CartePaiement cartePaiementDefaut;
	
	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<LigneCommande> lignesCommande;
	
	public Commande() {
		System.out.println("Commande");

		this.lignesCommande = new HashSet<LigneCommande>();
	}

	public Commande(@NotNull Integer numero, @NotNull Date dateCreation, @NotNull Date dateLivraison,
			@NotNull Double totalRemise, @NotNull Double fraisExpedition, @NotNull Double totalGeneral) {
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.lignesCommande = new HashSet<LigneCommande>();

	}
	

	public Commande(Integer id, @NotNull Integer numero, @NotNull Date dateCreation, @NotNull Date dateLivraison,
			@NotNull Double totalRemise, @NotNull Double fraisExpedition, @NotNull Double totalGeneral) {
		this.id = id;
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.lignesCommande = new HashSet<LigneCommande>();

	}

	public Commande(Integer id, @NotNull Integer numero, @NotNull Date dateCreation, @NotNull Date dateLivraison,
			@NotNull Double totalRemise, @NotNull Double fraisExpedition, @NotNull Double totalGeneral,
			Adresse adresseFacturation, Adresse adresseLivraison, CartePaiement cartePaiementDefaut,
			Utilisateur utilisateur) {
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
		this.lignesCommande = new HashSet<LigneCommande>();

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

	public Set<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(double totalRemise) {
		this.totalRemise = totalRemise;
	}

	public double getFraisExpedition() {
		return fraisExpedition;
	}


	public void setFraisExpedition(double fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public double getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(double totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public CartePaiement getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}

	
	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCreation=" + dateCreation + ", dateLivraison="
				+ dateLivraison + ", totalRemise=" + totalRemise + ", fraisExpedition=" + fraisExpedition
				+ ", totalGeneral=" + totalGeneral + ", adresseFacturation=" + adresseFacturation
				+ ", adresseLivraison=" + adresseLivraison + ", cartePaiementDefaut=" + cartePaiementDefaut
				+ ", utilisateur=" + utilisateur + "]";
	}


	
}
