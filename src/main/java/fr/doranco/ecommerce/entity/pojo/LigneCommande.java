package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ligneCommande", catalog = "ecommerce_db")

public class LigneCommande implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@NotNull
	@Column(name = "quantite", nullable = false)	
	private Integer quantite;
	
	@NotNull
	@Column(name = "prix_unitaire", nullable = false)
	private Double prixUnitaire; 
	@NotNull
	@Column(name = "remise_article", nullable = false)
	private Double remiseArticle; 	


	
	@ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commande;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;
	
	
	public LigneCommande() {
		System.out.println("LigneCommande");

	}

	public LigneCommande(@NotNull Double prixUnitaire, @NotNull Double remiseArticle) {
		super();
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
	}

	public LigneCommande(Integer id, @NotNull Integer quantite, @NotNull Double prixUnitaire,
			@NotNull Double remiseArticle) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
	}

	public LigneCommande(Integer id, @NotNull Integer quantite, @NotNull Double prixUnitaire,
			@NotNull Double remiseArticle, Commande commande, Article article) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	

}
