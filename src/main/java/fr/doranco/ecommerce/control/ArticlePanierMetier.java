package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.dto.ArticlePanierDto;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.ArticlePanierDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;

public class ArticlePanierMetier implements IArticlePanierMetier {

	
	 ArticlePanierDao  articlePanierDao = new  ArticlePanierDao(); 
	@Override
	public void addArticlePanierMetier(ArticlePanierDto articlePanierDto,Integer idUtilisateur , Integer idArticle) throws Exception {

		
		ArticlePanier articlePanier = new ArticlePanier();
		ArticlePanierDao articlePanierDao = new ArticlePanierDao();
		
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
	public void updateArticlePanier(ArticlePanierDto articlePanierDto,Integer idUtilisateur , Integer idArticle) throws Exception {
		ArticlePanier articlePanier = new ArticlePanier();

		ArticlePanierDao articlePanierDao = new ArticlePanierDao();
		
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
