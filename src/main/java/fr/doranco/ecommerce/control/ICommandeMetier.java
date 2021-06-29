package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.Commande;

public interface ICommandeMetier {

	void addCommande(Commande commande) throws Exception;
	Commande getCommandeById(Integer id) throws Exception;
	void updateCommande(Commande commande) throws Exception;
	void removeCommande(Commande commande) throws Exception;
	//test
}
