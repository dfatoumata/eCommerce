package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.model.dao.CommandeDao;
import fr.doranco.ecommerce.model.dao.ICommandeDao;

public class CommandeMetier implements ICommandeMetier{

	ICommandeDao commandeDao = new CommandeDao();
	@Override
	public void addCommande(Commande commande) throws Exception {
		commandeDao.add(commande);
		
	}

	@Override
	public Commande getCommandeById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return commandeDao.get(Commande.class, id);
	}


	@Override
	public void updateCommande(Commande commande) throws Exception {
		commandeDao.update(commande);
		
	}

	@Override
	public void removeCommande(Commande commande) throws Exception {
		commandeDao.remove(commande);
		
	}

	
	
}
