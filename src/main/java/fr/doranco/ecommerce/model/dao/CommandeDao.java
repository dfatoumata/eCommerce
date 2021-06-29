package fr.doranco.ecommerce.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.model.HibernateConnector;

public class CommandeDao extends AbstractEntityFacade<Commande> implements ICommandeDao {

	@Override
	public List<Commande> getListeCommandes1() {
		Session session = HibernateConnector.getInstance().getSession();
		String requette = "SELECT c FROM Commande c";
		Query<Commande> query = session.createQuery(requette, Commande.class);
		return query.list();
	}

	@Override
	public List<Commande> getListeCommandes2() {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createNamedQuery("Commande.findAll", Commande.class);
		return query.list();
	}

	@Override
	public List<Commande> getListeCommandes3() {
		Session session = HibernateConnector.getInstance().getSession();
		String requette = "SELECT * FROM commande";
		NativeQuery<Commande> query = session.createNativeQuery(requette, Commande.class);
		return query.list();
	}

	@Override
	public List<Commande> getListeCommandesById(Integer id) {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createNamedQuery("Commande.findById", Commande.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public List<Commande> getListeCommandesByUtilisateurId(Integer utilisateurId) {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createQuery("SELECT c FROM Utilisateur u JOIN  u.commandes c  WHERE u.id =:id",
				Commande.class);
		query.setParameter("id", utilisateurId);
		return query.getResultList();
	}

	@Override
	public List<Commande> getListeCommandesByNom(String nom) {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createQuery("SELECT c FROM  Utilisateur u JOIN u.commandes c WHERE u.nom =:nom",
				Commande.class);
		query.setParameter("nom", nom);
		return query.getResultList();
	}

	@Override
	public List<Commande> getListeCommandesByVille(String ville) {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createQuery(
				"SELECT DISTINCT(c) FROM Utilisateur u JOIN u.commandes c JOIN u.adresses a WHERE a.ville =:ville", Commande.class);
		query.setParameter("ville", ville);
		return query.getResultList();
	}

	@Override
	public Map<String, Integer> getNbCommandesByVille(String orderBy) {
		
		Session session = HibernateConnector.getInstance().getSession();	
//		pour La ville de Rennes ==>Il correspond à Utilisateur 1 ==> on prends les 2 adresses  
		String requete = null;
		Map<String, Integer> nbCommandesByVille = null;
		if (orderBy.equals("ville")) {
			requete = "SELECT a.ville, COUNT(DISTINCT(c)) AS nbCmd FROM Utilisateur u JOIN u.commandes c JOIN u.adresses a GROUP BY a.ville ORDER BY a.ville ASC ";
			nbCommandesByVille = new TreeMap<String, Integer>();
		}
		if (orderBy.equals("commande")) {
			requete = "SELECT a.ville, COUNT(DISTINCT(c)) AS nbCmd FROM Utilisateur u JOIN u.commandes c JOIN u.adresses a GROUP BY a.ville ORDER BY nbCmd ASC ";
			nbCommandesByVille = new HashMap<String, Integer>();
		}
		Query<?> query = session.createQuery(requete);
		
		List<Object[]> listeVilleCmd = (List<Object[]>) query.getResultList();
		
		for (Object[] objects : listeVilleCmd) {
			
			nbCommandesByVille.put((String)objects[0], ((Long) objects[1]).intValue());

		}
		return nbCommandesByVille;
	}

}
