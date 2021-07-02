package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.dto.ArticlePanierDto;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;

public interface IPanierMetier {

	void addArticle(ArticlePanierDto articlePanierDto, Integer idUtilisateur, Integer idArticle) throws Exception;

	ArticlePanier getArticlePanierById(Integer id) throws Exception;

	void updateArticlePanier(ArticlePanier articlePanier)
			throws Exception;


	List<ArticlePanier> getPanierByUser(Integer id) throws Exception;
	
	void removeArticlePanier(ArticlePanier articlePanierDto) throws Exception;

}
