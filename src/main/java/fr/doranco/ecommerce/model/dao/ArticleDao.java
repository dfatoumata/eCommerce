package fr.doranco.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Categorie;
import fr.doranco.ecommerce.model.HibernateConnector;

public class ArticleDao extends AbstractEntityFacade<Article> implements IArticleDao {

	@Override
	public List<Article> getArticlesByCategorie(Categorie categorie) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query query = session.createNativeQuery("SELECT a FROM Article a where a.categorie = ?");
		query.setParameter(1, categorie);
		List<Object[]> objects = (List<Object[]>) query.getResultList();
		List<Article> articles = new ArrayList<Article>();
		for (Object[] obj : objects) {
			Article article = new Article();
			article.setId((Integer)obj[0]);
			article.setNom((String)obj[1]);
			article.setDescription((String)obj[2]);
			article.setPrix((Double)obj[3]);
			article.setRemise((Integer)obj[4]);
            articles.add(article);
		}
		return articles;
	}
	
	@Override
	public List<Article> getArticlesByCategorie(String categorie) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query query = session.createNativeQuery("SELECT a FROM Article a where a.categorie.nom = ?");
		query.setParameter(1, categorie);
		List<Object[]> objects = (List<Object[]>) query.getResultList();
		List<Article> articles = new ArrayList<Article>();
		for (Object[] obj : objects) {
			Article article = new Article();
			article.setId((Integer)obj[0]);
			article.setNom((String)obj[1]);
			article.setDescription((String)obj[2]);
			article.setPrix((Double)obj[3]);
			article.setRemise((Integer)obj[4]);
            articles.add(article);
		}
		return articles;
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
