package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.LigneCommande;

public interface ILigneCommandeMetier {

	void addLigneCommande(LigneCommande ligneCommande) throws Exception;
	LigneCommande getLigneCommandeById(Integer id) throws Exception;
	LigneCommande getLigneCommandeByEmail(String email) throws Exception;
	void updateLigneCommande(LigneCommande ligneCommande) throws Exception;
	void removeLigneCommande(LigneCommande ligneCommande) throws Exception;
}
