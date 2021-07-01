package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.dto.ArticlePanierDto;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;

public interface IArticlePanierMetier {

	void addArticlePanierMetier(ArticlePanierDto articlePanierDto,Integer idUtilisateur , Integer idArticle) throws Exception;
	ArticlePanier getArticlePanierById(Integer id) throws Exception;
	void updateArticlePanier(ArticlePanierDto articlePanierDto,Integer idUtilisateur , Integer idArticle) throws Exception;
	void removeArticlePanier(ArticlePanierDto articlePanierDto) throws Exception;
	
	
}
