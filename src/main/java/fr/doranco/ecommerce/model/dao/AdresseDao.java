package fr.doranco.ecommerce.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.model.HibernateConnector;

public class AdresseDao extends AbstractEntityFacade<Adresse> implements IAdresseDao {

	@Override
	public List<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Adresse> query = session.createQuery("SELECT a FROM Utilisateur u JOIN  u.adresses a  WHERE u.id =:id",
				Adresse.class);
		query.setParameter("id", idUtilisateur);
		return query.getResultList();
	}

	
	@Override
	public List<String> getNomsVillesUtilisateurs() throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query<String> query = session.createQuery("SELECT a.ville FROM Utilisateur u JOIN  u.adresses a  WHERE u.id =:id",
				String.class);
		return query.getResultList();
	}

}
