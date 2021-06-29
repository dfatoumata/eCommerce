package fr.doranco.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ligneCommande", catalog = "ecommerce_db_hibernate")

public class ArticlePanier implements Serializable  {

	private static final long serialVersionUID = 1L;

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	
	@OneToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;
	
	@NotNull
	@Column(name = "quantite", nullable = false)	
	private Integer quantite;
	
	@OneToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur_id;

	public ArticlePanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticlePanier(Integer id, Article article, @NotNull Integer quantite, Utilisateur utilisateur_id) {
		super();
		this.id = id;
		this.article = article;
		this.quantite = quantite;
		this.utilisateur_id = utilisateur_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Utilisateur getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(Utilisateur utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
