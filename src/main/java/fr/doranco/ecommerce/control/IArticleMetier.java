package fr.doranco.ecommerce.control;

import java.util.List;
import java.util.Set;

import fr.doranco.ecommerce.entity.dto.ArticleDto;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;

public interface IArticleMetier {

	
	//CRUD
	void addArticle(ArticleDto articleDto) throws Exception;
	Article getArticleById(Integer id) throws Exception;
	void updateArticle(ArticleDto articleDto) throws Exception;
	void removeArticle(ArticleDto articleDto) throws Exception;
	
	List<Article> getArticles() throws Exception;
	List<Article> getArticleByCategorie(String categorie) throws Exception;

}
