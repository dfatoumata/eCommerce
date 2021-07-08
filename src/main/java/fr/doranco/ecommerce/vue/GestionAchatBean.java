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

	private IPanierMetier panierMetier = new PanierMetier();
	private IUtilisateurMetier userMetier = new UtilisateurMetier();

	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = " ";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = " ";
	Utilisateur user = LoginBean.getConnectedUser();

	public GestionAchatBean() {
	}

	public String ajouterAuPanier(Article article, String quantite) {

		System.out.println(user.getPanier());
		Integer qte = Integer.valueOf(quantite);

		ArticlePanier articlePanier = null;
		boolean isFound = false;

		for (ArticlePanier ap : user.getPanier()) {
			if (ap.getArticle().getId().equals(article.getId())) {
				articlePanier = ap;
				isFound = true;
			}
		}
		if (isFound) {
			Integer indexArticlePanier = user.getPanier().indexOf(articlePanier);
			articlePanier.setQuantite(articlePanier.getQuantite() + qte);
			user.getPanier().set(indexArticlePanier, articlePanier);


		} else {
			ArticlePanier newArticlePanier = new ArticlePanier(article, Integer.valueOf(quantite));
			newArticlePanier.setUtilisateur(user);;
			user.getPanier().add(newArticlePanier);
//			newArticlePanier.setUtilisateur(user);;
//			user.getPanier().add(newArticlePanier);
			//pb 1 article panier n'a pas d'utilisateur, 
			//pb 2 
			// Voir l'explication de Asmaa si l'utilisateur n'a pas d'article dans son panier alors faire le Add 
		}

		try {
			userMetier.updateUtilisateur(user);
			messageSuccess = "Article ajouté avec succès au panier";
		} catch (Exception e1) {

			e1.printStackTrace();
			return "";
		}
		
		return "";
	}

//	public String ajouterAuPanier2(Article article, String quantite) {
//
//		System.out.println(user.getPanier());
//		Integer qte = Integer.valueOf(quantite);
//		ArticlePanier articlePanier = new ArticlePanier();
//		articlePanier.setArticle(article);
//		articlePanier.setUtilisateur(user);
//
//		if (user.getPanier().contains(articlePanier)) {
//			Integer oldQuantite = user.getPanier().get(user.getPanier().indexOf(articlePanier)).getQuantite();
//			user.getPanier().get(user.getPanier().indexOf(articlePanier)).setQuantite(qte + oldQuantite);
//		}
//		Boolean IsArticleIdentiqueDansUserPanier = false;
//
//		List<ArticlePanier> articlePaniers = null;
//		try {
//			articlePaniers = panierMetier.getPanierByUser(user.getId());
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		for (ArticlePanier articleP : articlePaniers) {
//
//			if (article.getId().equals(articleP.getArticle().getId())
//					&& articlePanier.getUtilisateur().getId().equals(articleP.getUtilisateur().getId())) {
//				Integer oldQuantite = articleP.getQuantite();
//				articlePanier.setQuantite(qte + oldQuantite);
//				int index = articlePaniers.indexOf(articleP);
//
//				articlePaniers.set(index, articlePanier);
//				IsArticleIdentiqueDansUserPanier = true;
//
//			}
//		}
//
//		if (!IsArticleIdentiqueDansUserPanier) {
//			articlePanier.setQuantite(qte);
//
//			articlePaniers.add(articlePanier);
//		}
//
//		try
//
//		{
//			panierMetier.updateArticlePanier(articlePanier);
//			messageSuccess = "Article ajouté avec succès au panier";
//		} catch (Exception e1) {
//
//			e1.printStackTrace();
//			return "";
//		}
//
//		return "";
//	}

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
