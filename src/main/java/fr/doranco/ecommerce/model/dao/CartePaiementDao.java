package fr.doranco.ecommerce.model.dao;

import java.util.List;

<<<<<<< HEAD
=======

>>>>>>> branch 'Fatou' of https://github.com/dfatoumata/eCommerce.git
import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.model.HibernateConnector;

public class CartePaiementDao extends AbstractEntityFacade<CartePaiement> implements ICartePaiementDao {

	@Override
<<<<<<< HEAD
	public List<CartePaiement> getCartelesById(Integer idUser) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query<CartePaiement> query = session.createQuery("SELECT a FROM Utilisateur u JOIN  u.carte_paiement c  WHERE u.id =:id",
				CartePaiement.class);
		query.setParameter("id", idUser);
		return query.getResultList();
	}


}
=======
	public List<CartePaiement> getCartePaiementByUserId(Integer id) throws Exception {

		Session session = HibernateConnector.getInstance().getSession();
		Query<?> query = session.createQuery("SELECT c FROM Utilisateur u JOIN  u.cartePaiements c  WHERE u.id =:id");
		query.setParameter("id", id);

		return (List<CartePaiement>) query.getResultList();
	}

}
>>>>>>> branch 'Fatou' of https://github.com/dfatoumata/eCommerce.git
