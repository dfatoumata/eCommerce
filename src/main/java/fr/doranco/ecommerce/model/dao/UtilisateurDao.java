package fr.doranco.ecommerce.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.model.HibernateConnector;

public class UtilisateurDao extends AbstractEntityFacade<Utilisateur> implements IUtilisateurDao {

	IAdresseDao adresseDao = new AdresseDao();

public UtilisateurDao() {
	// TODO Auto-generated constructor stub
}
	
//	@Override
//	public Utilisateur getUtilisateurById(Integer id) throws Exception {
//		return null;
//	}

	@Override
	public void add(Utilisateur entity) throws Exception {
		// TODO Auto-generated method stub
		super.add(entity);
	}

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
				"SELECT u FROM Utilisateur u WHERE u.adresses.ville =:ville", Utilisateur.class);
		query.setParameter("ville", ville);
		return query.getResultList();

	}



}
