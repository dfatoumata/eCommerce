package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.ArticlePanierDao;

public class ArticlePanierMetier implements IArticlePanierMetier {

	
	 ArticlePanierDao  articlePanierDao = new  ArticlePanierDao(); 
	@Override
	public void addArticlePanierMetier(ArticlePanier articlePanier) throws Exception {
		articlePanierDao.add(articlePanier);
		
	}

	@Override
	public ArticlePanier getArticlePanierById(Integer id) throws Exception {
		return null;
	}

	@Override
	public void updateArticlePanier(ArticlePanier articlePanier) throws Exception {
		articlePanierDao.update(articlePanier);
		
	}

	@Override
	public void removeArticlePanier(ArticlePanier articlePanier) throws Exception {
	articlePanierDao.remove(articlePanier);
		
	}
	

}
