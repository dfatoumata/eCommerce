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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categorie", catalog = "ecommerce_db_hibernate")

public class Categorie  implements Serializable  {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	
	@NotEmpty
	@Column(name = "remise", length = 3, nullable = false)
	private Integer remise;
	
	@OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Article> articles;

	public Categorie(Integer id, @NotEmpty String nom, @NotEmpty Integer remise) {
		super();
		this.id = id;
		this.nom = nom;
		this.remise = remise;
		
		articles = new HashSet<Article>();
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
		articles = new HashSet<Article>();

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

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", remise=" + remise + ", articles=" + articles + "]";
	}
	
	
	
	
	
	
	
	
}
