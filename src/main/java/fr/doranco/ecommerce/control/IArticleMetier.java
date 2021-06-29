package fr.doranco.ecommerce.control;

import java.util.List;
import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;

public interface IArticleMetier {

	
	//CRUD
	void addArticle(Article article) throws Exception;
	Article getArticleById(Integer id) throws Exception;
	void updateArticle(Article article) throws Exception;
	void removeArticle(Article article) throws Exception;
	
	List<Article> getArticles() throws Exception;
	List<Article> getArticleByCategorie(String categorie) throws Exception;

}
