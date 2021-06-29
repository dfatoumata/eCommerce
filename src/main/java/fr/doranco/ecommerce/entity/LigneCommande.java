package fr.doranco.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ligneCommande", catalog = "ecommerce_db_hibernate")

public class LigneCommande implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "titre_article", length = 45, nullable = false)
	private String titreArticle;
	
	@NotNull
	@Column(name = "prix_article", nullable = false)
	private Integer prixArticle; 
	
	@NotNull
	@Column(name = "quantite", nullable = false)	
	private Integer quantite;
	
	@ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commande;
	
	@OneToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;
	
	public LigneCommande() {
		// TODO Auto-generated constructor stub
	}

	protected LigneCommande(String titreArticle, Integer prixArticle, Integer quantite,Article article) {
		this.titreArticle = titreArticle;
		this.prixArticle = prixArticle;
		this.quantite = quantite;
		this.article = article;
	}

	public Integer getId() {
		return id;
	}
	

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitreArticle() {
		return titreArticle;
	}

	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}

	public Integer getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(Integer prixArticle) {
		this.prixArticle = prixArticle;
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

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", titreArticle=" + titreArticle + ", prixArticle=" + prixArticle
				+ ", quantite=" + quantite + "]";
	}
	
	

}
