package fr.doranco.ecommerce.model.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.model.HibernateConnector;

public class CartePaiementDao extends AbstractEntityFacade<CartePaiement> implements ICartePaiementDao {

	@Override
	public List<CartePaiement> getCartePaiementByUserId(Integer id) throws Exception {

		Session session = HibernateConnector.getInstance().getSession();
		Query<?> query = session.createQuery("SELECT c FROM Utilisateur u JOIN  u.cartePaiements c  WHERE u.id =:id");
		query.setParameter("id", id);

		return (List<CartePaiement>) query.getResultList();
	}

}
