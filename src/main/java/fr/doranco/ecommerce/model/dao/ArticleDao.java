package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Categorie;

public class ArticleDao extends AbstractEntityFacade<Article> implements IArticleDao {

	@Override
	public List<Article> getArticlesByCategorie(Categorie categorie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Map<String, List<Utilisateur>> getUtilisateursByVille() throws Exception {
//		Session session = HibernateConnector.getInstance().getSession();	
//		String requete = "SELECT a.ville, u FROM Utilisateur u JOIN u.adresses a GROUP BY a.ville ORDER BY a.ville ASC ";
//
//		Map<String, List<Utilisateur>> nbUtilisateursByVille = new TreeMap<String, List<Utilisateur>>();
//		Query<?> query = session.createQuery(requete);
//		
//		List<Object[]> listeVilleUser = (List<Object[]>) query.getResultList();
//		
//		for (Object[] VilleListeUser : listeVilleUser) {
//			
//			nbUtilisateursByVille.put((String) VilleListeUser[0], (List<Utilisateur>) VilleListeUser[1]);
//
//		}
//		
//		return nbUtilisateursByVille;
//	}
//
//	@Override
//	public List<Utilisateur> getUtilisateursOfVille(String ville) throws Exception {
//		Session session = HibernateConnector.getInstance().getSession();
//		Query<Utilisateur> query = session.createQuery(
//				"SELECT u FROM Utilisateur u JOIN u.commandes c JOIN u.adresses a WHERE a.ville =:ville", Utilisateur.class);
//		query.setParameter("ville", ville);
//		return query.getResultList();
//	}


	
	
}
