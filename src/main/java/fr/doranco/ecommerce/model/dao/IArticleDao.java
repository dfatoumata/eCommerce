package fr.doranco.ecommerce.model.dao;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.Utilisateur;

public interface IArticleDao extends IEntityFacade<Utilisateur> {

//	Utilisateur getUtilisateurByEmail(String email) throws Exception;
	Map<String, List<Utilisateur>> getUtilisateursByVille() throws Exception;
	List<Utilisateur> getUtilisateursOfVille(String ville) throws Exception;
	
}
