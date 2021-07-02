package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.dto.ArticlePanierDto;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.IPanierDao;
import fr.doranco.ecommerce.model.dao.PanierDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;

public class PanierMetier implements IPanierMetier {


	public PanierMetier() {
		// TODO Auto-generated constructor stub
	}

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
	public void updateArticlePanier(ArticlePanier articlePanier) throws Exception {
		PanierDao articlePanierDao = new PanierDao();

		articlePanierDao.update(articlePanier);

	}

	@Override
	public void removeArticlePanier(ArticlePanier articlePanierDto) throws Exception {
		PanierDao articlePanierDao = new PanierDao();

//		ArticlePanier articlePanier = new ArticlePanier();
		articlePanierDao.remove(articlePanierDto);

	}

	@Override
	public List<ArticlePanier> getPanierByUser(Integer id) throws Exception {
		IPanierDao panierDao = new PanierDao();
		return panierDao.getPanierByUser(id);
	}

}
