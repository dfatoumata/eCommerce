package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;

public class ArticleMetier implements IArticleMetier {

	
	ArticleDao articleDao = new ArticleDao(); 
	@Override
	public void addArticle(Article article) throws Exception {
		articleDao.add(article);
		
	}

	@Override
	public Article getArticleById(Integer id) throws Exception {
	
		return articleDao.get(Article.class, id);}

	@Override
	public void updateArticle(Article article) throws Exception {
		articleDao.update(article);
		
	}

	@Override
	public void removeArticle(Article Article) throws Exception {
		articleDao.remove(Article);
		
	}

	@Override
	public List<Article> getArticles() throws Exception {
		// TODO Auto-generated method stub
		return articleDao.getAll(Article.class);
	}

	@Override
	public List<Article> getArticleByCategorie(String categorie) throws Exception {
		//articleDao.getArticleByCategorie(categorie); 
		return null;
	}
	

}
