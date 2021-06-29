package fr.doranco.ecommerce.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.model.HibernateConnector;

public class UtilisateurDao extends AbstractEntityFacade<Utilisateur> implements IUtilisateurDao {

	IAdresseDao adresseDao = new AdresseDao();


//	@Override
//	public Utilisateur getUtilisateurById(Integer id) throws Exception {
//		return null;
//	}

	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Utilisateur> query = session.createQuery(
				"SELECT u FROM Utilisateur u  WHERE u.email =:email", Utilisateur.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}
	

	@Override
	public List<Utilisateur> getUtilisateursByVille(String ville) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Utilisateur> query = session.createQuery(
				"SELECT u FROM Utilisateur u JOIN u.commandes c JOIN u.adresses a WHERE a.ville =:ville", Utilisateur.class);
		query.setParameter("ville", ville);
		return query.getResultList();

	}



}
