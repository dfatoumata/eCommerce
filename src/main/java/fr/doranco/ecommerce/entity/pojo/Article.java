package fr.doranco.ecommerce.entity.pojo;

import java.awt.image.BufferedImage;
import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "article", catalog = "ecommerce_db_hibernate")

public class Article  implements Serializable  {
	
	/*id
nom
description
prix
remise (en %)
stock
isVendable (ne se vend
plus ou non)
photos
video
commentaires */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	
	@NotEmpty
	@Column(name = "description", length = 100, nullable = false)
	private String description;
	

	@NotEmpty
	@Column(name = "prix", length = 4, nullable = false)
	private float prix;
	
	@NotEmpty
	@Column(name = "remise", length = 3, nullable = false)
	private Integer remise;
	
	@NotEmpty
	@Column(name = "stock", length = 10, nullable = false)
	private Integer stock;
	
	@NotEmpty
	@Column(name = "isVendable", length = 1, nullable = false)
	private boolean isVendable;
	
	
	@NotEmpty
	@Column(name = "photos", length = 10, nullable = false)
	private BufferedImage  photos;
 
	
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorie;
	
	@OneToOne
	private Article article;

	public Article(Integer id, @NotEmpty String nom, @NotEmpty String description, @NotEmpty float prix,
			@NotEmpty Integer remise, @NotEmpty Integer stock, @NotEmpty boolean isVendable,
			@NotEmpty BufferedImage photos, Set<Commentaire> commentaires, Categorie categorie, Article article) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		this.photos = photos;
		this.commentaires = commentaires;
		this.categorie = categorie;
		this.article = article;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public boolean isVendable() {
		return isVendable;
	}

	public void setVendable(boolean isVendable) {
		this.isVendable = isVendable;
	}

	public BufferedImage getPhotos() {
		return photos;
	}

	public void setPhotos(BufferedImage photos) {
		this.photos = photos;
	}

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	

	

}
