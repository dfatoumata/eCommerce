package fr.doranco.ecommerce.model.dao;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.pojo.Commande;

public interface ICommandeDao extends IEntityFacade<Commande> {

	List<Commande> getListeCommandes1(); //version 1
	List<Commande> getListeCommandes2(); //version 2
	List<Commande> getListeCommandes3(); //version 3
	List<Commande> getListeCommandesById(Integer id);
	List<Commande> getListeCommandesByUtilisateurId(Integer utilisateurId);
	List<Commande> getListeCommandesByNom(String nom);
	List<Commande> getListeCommandesByVille(String ville);
	Map<String, Integer> getNbCommandesByVille(String nomVilleOuNbCommandes);

	
}
