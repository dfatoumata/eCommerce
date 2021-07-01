package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.dto.ArticleDto;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;

public class ArticleMetier implements IArticleMetier {
	ArticleDao articleDao = new ArticleDao(); 

	public ArticleMetier() {
	}
	

	
	@Override
	public void addArticle(ArticleDto articleDto) throws Exception {
	
		Article article = new Article();
		
		article.setNom(articleDto.getNom().substring(0, 1).toUpperCase()
				.concat(articleDto.getNom().substring(1).toLowerCase()));
		
		article.setDescription(articleDto.getDescription().substring(0, 1).toUpperCase()
				.concat(articleDto.getDescription().substring(1).toLowerCase()));
		
		article.setPrix(Double.parseDouble(articleDto.getPrix()) );
		
		article.setRemise(Integer.parseInt(articleDto.getRemise()));
		
		
		articleDao.add(article);
		
	}

	@Override
	public Article getArticleById(Integer id) throws Exception {
	
		return articleDao.get(Article.class, id);}

	@Override
	public void updateArticle(ArticleDto articleDto) throws Exception {
		Article article = new Article();
		article.setNom(articleDto.getNom().substring(0, 1).toUpperCase()
				.concat(articleDto.getNom().substring(1).toLowerCase()));
		
		article.setDescription(articleDto.getDescription().substring(0, 1).toUpperCase()
				.concat(articleDto.getDescription().substring(1).toLowerCase()));
		
		article.setPrix(Double.parseDouble(articleDto.getPrix()) );
		
		article.setRemise(Integer.parseInt(articleDto.getRemise()));
		
		articleDao.update(article);
		
	}

	@Override
	public void removeArticle(ArticleDto articleDto) throws Exception {
		Article article = new Article();
		articleDao.remove(article);
		
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
