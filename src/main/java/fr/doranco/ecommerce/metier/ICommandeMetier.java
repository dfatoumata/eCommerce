package fr.doranco.ecommerce.metier;

import fr.doranco.ecommerce.entity.dto.CommandeDto;
import fr.doranco.ecommerce.entity.pojo.Commande;

public interface ICommandeMetier {

	void addCommande(CommandeDto commandeDto) throws Exception;
	Commande getCommandeById(Integer id) throws Exception;
	void updateCommande(Commande commande) throws Exception;
	void removeCommande(Commande commande) throws Exception;
	//test
}
