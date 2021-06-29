package fr.doranco.ecommerce.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.LigneCommande;
import fr.doranco.ecommerce.model.HibernateConnector;

public class LigneCommandeDao extends AbstractEntityFacade<LigneCommande> implements ILigneCommandeDao {

	@Override
	public List<LigneCommande> getListeLigneCommandesByCommandeId(Integer commandeId) {
		Session session = HibernateConnector.getInstance().getSession();
		Query<LigneCommande> query = session.createQuery("SELECT lc FROM Commande c JOIN  c.lignesCommande lc  WHERE c.id =:id",
				LigneCommande.class);
		query.setParameter("id", commandeId);
		return query.getResultList();
	}

}
