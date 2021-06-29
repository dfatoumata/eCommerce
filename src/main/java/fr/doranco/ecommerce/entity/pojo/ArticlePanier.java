package fr.doranco.ecommerce.entity.pojo;

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
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "articlePanier", catalog = "ecommerce_db")
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
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;

	public ArticlePanier() {
	}

	public ArticlePanier(Article article, @NotNull Integer quantite) {
		super();
		this.article = article;
		this.quantite = quantite;
	}

	public ArticlePanier(Integer id, Article article, @NotNull Integer quantite) {
		super();
		this.id = id;
		this.article = article;
		this.quantite = quantite;
	}

	public ArticlePanier(Integer id, Article article, @NotNull Integer quantite, Utilisateur utilisateur) {
		this.id = id;
		this.article = article;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", article=" + article + ", quantite=" + quantite + "]";
	}

}
