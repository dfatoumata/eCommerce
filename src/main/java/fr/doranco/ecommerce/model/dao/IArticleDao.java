package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Categorie;

public interface IArticleDao extends IEntityFacade<Article> {

	List<Article> getArticlesByCategorie(Categorie categorie) throws Exception;
	
}
