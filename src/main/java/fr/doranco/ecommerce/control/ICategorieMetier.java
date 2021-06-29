package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.Categorie;

public interface ICategorieMetier {

	void addCategorie(Categorie categorie) throws Exception;
	Categorie getCategorieById(Integer id) throws Exception;
	Categorie getCategorieByEmail(String email) throws Exception;
	void updateCategorie(Categorie categorie) throws Exception;
	void removeCategorie(Categorie categorie) throws Exception;
}
