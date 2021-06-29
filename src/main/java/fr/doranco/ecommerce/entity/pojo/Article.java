package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "article", catalog = "ecommerce_db")

public class Article  implements Serializable  {

	private static final long serialVersionUID = 1L;

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
	private Double prix;
	
	@NotEmpty
	@Column(name = "remise", length = 3, nullable = false)
	private Integer remise;
	
	@NotEmpty
	@Column(name = "stock", length = 10, nullable = false)
	private Integer stock;
	
	@NotEmpty
	@Column(name = "isVendable", nullable = false)
	private Boolean isVendable;

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorie;


	public Article() {
		commentaires = new HashSet<Commentaire>();
	}

	
	public Article(@NotEmpty String nom, @NotEmpty String description, @NotEmpty Double prix, @NotEmpty Integer remise,
			@NotEmpty Integer stock, @NotEmpty Boolean isVendable) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		commentaires = new HashSet<Commentaire>();

	}

	public Article(Integer id, @NotEmpty String nom, @NotEmpty String description, @NotEmpty Double prix,
			@NotEmpty Integer remise, @NotEmpty Integer stock, @NotEmpty Boolean isVendable) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;		
		commentaires = new HashSet<Commentaire>();

	}


	public Article(Integer id, @NotEmpty String nom, @NotEmpty String description, @NotEmpty Double prix,
			@NotEmpty Integer remise, @NotEmpty Integer stock, @NotEmpty Boolean isVendable,
			Set<Commentaire> commentaires, Categorie categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		this.commentaires = commentaires;
		this.categorie = categorie;
		commentaires = new HashSet<Commentaire>();

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


	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}


	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Double getPrix() {
		return prix;
	}


	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public Boolean getIsVendable() {
		return isVendable;
	}


	public void setIsVendable(Boolean isVendable) {
		this.isVendable = isVendable;
	}


	

}
