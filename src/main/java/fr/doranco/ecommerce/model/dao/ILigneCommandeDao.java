package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.LigneCommande;

public interface ILigneCommandeDao extends IEntityFacade<LigneCommande> {
	
	List<LigneCommande> getListeLigneCommandesByCommandeId(Integer commandeId);
//	List<LigneCommande> getListeCommandesByNom(String nom);
//	List<LigneCommande> getListeCommandesByVille(String ville);
//	Map<String, Integer> getNbCommandesByVille(String nomVilleOuNbCommandes);
	
}
