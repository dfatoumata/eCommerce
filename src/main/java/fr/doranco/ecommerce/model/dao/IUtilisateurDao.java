package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.Utilisateur;

public interface IUtilisateurDao extends IEntityFacade<Utilisateur> {

	Utilisateur getUtilisateurById(Integer id) throws Exception;
	Utilisateur getUtilisateurByEmail(String email) throws Exception;
	
	List<Utilisateur> getUtilisateursByVille(String ville) throws Exception;
}
