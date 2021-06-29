package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "commentaire", catalog = "ecommerce_db_hibernate")

public class Commentaire  implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
	@Column(name = "id")
	private Integer id ;
	
	@NotNull
	@Column(name = "texte", nullable = false)
	private Integer texte ;
	
	@NotNull
	@Column(name = "note", nullable = false)
	private Integer note ;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;

	public Commentaire(Integer id, @NotNull Integer texte, @NotNull Integer note, Utilisateur utilisateur ,Article article) {
		super();
		this.id = id;
		this.texte = texte;
		this.note = note;
		this.utilisateur = utilisateur;
		this.article= article;
		
	}

	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTexte() {
		return texte;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setTexte(Integer texte) {
		this.texte = texte;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
}
