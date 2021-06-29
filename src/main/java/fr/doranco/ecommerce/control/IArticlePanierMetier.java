package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;

public interface IArticlePanierMetier {

	void addArticlePanierMetier(ArticlePanier articlePanier) throws Exception;
	ArticlePanier getArticlePanierById(Integer id) throws Exception;
	void updateArticlePanier(ArticlePanier articlePanier) throws Exception;
	void removeArticlePanier(ArticlePanier articlePanier) throws Exception;
	
	
}
