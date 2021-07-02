package fr.doranco.ecommerce.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.model.HibernateConnector;

public class PanierDao extends AbstractEntityFacade<ArticlePanier> implements IPanierDao {

	@Override
	public List<ArticlePanier> getPanierByUser(Integer id) throws Exception {
		
		Session session = HibernateConnector.getInstance().getSession();
		Query<?> query = session.createQuery("SELECT p FROM Utilisateur u JOIN  u.panier p  WHERE u.id =:id");
		query.setParameter("id", id);
		
		return (List<ArticlePanier>) query.getResultList();

	}


}
