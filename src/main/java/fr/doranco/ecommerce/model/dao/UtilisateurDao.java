package fr.doranco.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.ecommerce.entity.Utilisateur;

public class UtilisateurDao extends AbstractEntityFacade<Utilisateur> implements IUtilisateurDao {

	IAdresseDao adresseDao = new AdresseDao();


	@Override
	public Utilisateur getUtilisateurById(Integer id) throws Exception {
		return null;
	}

	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
	
		return null;
	}
	

	@Override
	public List<Utilisateur> getUtilisateursByVille(String ville) throws Exception {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		return utilisateurs;
	}



}
