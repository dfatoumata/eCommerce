package fr.doranco.ecommerce.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "commande", catalog = "hibernate_db_anot")
@NamedQueries({
	@NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
	@NamedQuery(name = "Commande.findById", query = "SELECT c FROM Commande c WHERE id =:id")
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
	@Column(name = "date_commande", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCommande ;
	
	@NotNull
	@Column(name = "date_livraison", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateLivraison ;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LigneCommande> lignesCommande;
	
	public Commande() {
		this.lignesCommande = new ArrayList<LigneCommande>();
	}
	
	public Commande(Integer numero, Date dateCommande, Date dateLivraison) {
		this.numero = numero;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
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

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
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

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + ", dateLivraison="
				+ dateLivraison + "]";
	}
	
	
}
