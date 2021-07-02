package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.IArticleMetier;
import fr.doranco.ecommerce.metier.IPanierMetier;
import fr.doranco.ecommerce.metier.IUtilisateurMetier;
import fr.doranco.ecommerce.metier.PanierMetier;
import fr.doranco.ecommerce.metier.UtilisateurMetier;

@ManagedBean(name = "gestionAchatBean")
@SessionScoped
public class GestionAchatBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = " ";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = " ";
	Utilisateur user = LoginBean.getConnectedUser();

	public GestionAchatBean() {
	}

	public String ajouterAuPanier(Article article, String quantite) {

		Integer qte = Integer.valueOf(quantite);

		ArticlePanier articlePanier = new ArticlePanier();
		articlePanier.setArticle(article);
		articlePanier.setUtilisateur(user);
		
//		if (user.getPanier().contains(articlePanier)) {
//			Integer oldQuantite = user.getPanier().get(user.getPanier().indexOf(articlePanier)).getQuantite();
//			user.getPanier().get(user.getPanier().indexOf(articlePanier)).setQuantite(qte + oldQuantite);
//		}
		Boolean IsArticleIdentiqueDansUserPanier = false ;
		
		for (ArticlePanier articleP : user.getPanier()) {

			if (article.getId().equals(articleP.getArticle().getId()) && articlePanier.getUtilisateur().getId().equals(articleP.getUtilisateur().getId())) {
				Integer oldQuantite = articleP.getQuantite();
				articlePanier.setQuantite(qte + oldQuantite);
				int index = user.getPanier().indexOf(articleP);
				
				user.getPanier().set(index, articlePanier);
				IsArticleIdentiqueDansUserPanier = true;

			}
		}

		if (!IsArticleIdentiqueDansUserPanier) {
			articlePanier.setQuantite(qte);
			user.getPanier().add(articlePanier);
		}
		
		user.getPanier().remove(articlePanier);
		IPanierMetier panierMetier = new PanierMetier();

//		try {
//			panierMetier.removeArticlePanier(articlePanier);
			
		IUtilisateurMetier utilisateurMetier = new UtilisateurMetier();
		
		try {
			utilisateurMetier.updateUtilisateur(user);
			messageSuccess = "Article ajouté avec succès au panier";
			// afficher un popup indiquant que l'article a été ajouté au panier
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}

	public List<Article> getArticles() {

		IArticleMetier articleMetier = new ArticleMetier();

		List<Article> articles = new ArrayList<Article>();
		try {
			articles = articleMetier.getArticles();
		} catch (Exception e) {
			messageError = "Erreur technique ! Veuillez réessayer plus tard.\n" + e.getMessage();
			e.printStackTrace();
		}

		return articles;
	}


	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
