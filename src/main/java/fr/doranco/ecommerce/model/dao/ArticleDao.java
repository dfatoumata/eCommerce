package fr.doranco.ecommerce.model.dao;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.Utilisateur;

public class ArticleDao extends AbstractEntityFacade<Utilisateur> implements IArticleDao {

	@Override
	public Map<String, List<Utilisateur>> getUtilisateursByVille() throws Exception {
		return null;
	}

	@Override
	public List<Utilisateur> getUtilisateursOfVille(String ville) throws Exception {
		return null;
	}

}
