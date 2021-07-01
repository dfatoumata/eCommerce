package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entity.dto.ArticlePanierDto;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.PanierDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;

public class PanierMetier implements IPanierMetier {

	PanierDao articlePanierDao = new PanierDao();

	@Override
	public void addArticle(ArticlePanierDto articlePanierDto, Integer idUtilisateur, Integer idArticle)
			throws Exception {

		ArticlePanier articlePanier = new ArticlePanier();
		PanierDao articlePanierDao = new PanierDao();

		UtilisateurDao utilisateurDao = new UtilisateurDao();

		Utilisateur utilisateur = utilisateurDao.get(Utilisateur.class, idUtilisateur);

		articlePanier.setUtilisateur(utilisateur);

		ArticleDao articleDao = new ArticleDao();

		Article article = articleDao.get(Article.class, idArticle);

		articlePanier.setArticle(article);

		articlePanierDao.add(articlePanier);

	}

	@Override
	public ArticlePanier getArticlePanierById(Integer id) throws Exception {
		return null;
	}

	@Override
	public void updateArticlePanier(ArticlePanierDto articlePanierDto, Integer idUtilisateur, Integer idArticle)
			throws Exception {
		ArticlePanier articlePanier = new ArticlePanier();

		PanierDao articlePanierDao = new PanierDao();

		UtilisateurDao utilisateurDao = new UtilisateurDao();

		Utilisateur utilisateur = utilisateurDao.get(Utilisateur.class, idUtilisateur);

		articlePanier.setUtilisateur(utilisateur);

		ArticleDao articleDao = new ArticleDao();

		Article article = articleDao.get(Article.class, idArticle);

		articlePanier.setArticle(article);

		articlePanierDao.update(articlePanier);

	}

	@Override
	public void removeArticlePanier(ArticlePanierDto articlePanierDto) throws Exception {
		ArticlePanier articlePanier = new ArticlePanier();
		articlePanierDao.remove(articlePanier);

	}

}
