package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Article;
<<<<<<< HEAD
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
=======
import fr.doranco.ecommerce.entity.pojo.Categorie;
>>>>>>> branch 'Fatou' of https://github.com/dfatoumata/eCommerce.git

public interface IArticleDao extends IEntityFacade<Article> {

	List<Article> getArticlesByCategorie(Categorie categorie) throws Exception;
	
}
