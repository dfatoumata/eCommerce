package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entity.dto.ArticlePanierDto;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;

public interface IPanierMetier {

	void addArticle(ArticlePanierDto articlePanierDto, Integer idUtilisateur, Integer idArticle) throws Exception;

	ArticlePanier getArticlePanierById(Integer id) throws Exception;

	void updateArticlePanier(ArticlePanier articlePanier, Integer idUtilisateur, Integer idArticle)
			throws Exception;



	void removeArticlePanier(ArticlePanier articlePanierDto) throws Exception;

}
