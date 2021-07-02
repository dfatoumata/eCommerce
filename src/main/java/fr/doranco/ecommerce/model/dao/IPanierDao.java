package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.ArticlePanier;

public interface IPanierDao extends IEntityFacade<ArticlePanier> {

	List<ArticlePanier> getPanierByUser(Integer id) throws Exception;
}
