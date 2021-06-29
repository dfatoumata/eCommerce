package fr.doranco.ecommerce.control;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Adresse;

public interface IAdresseMetier {

	//CRUD
	void addAdresse(Adresse adresse, Integer idUtilisateur) throws Exception;
	Adresse getAdresseById(Integer id) throws Exception;
	void updateAdresse(Adresse adresse) throws Exception;
	void removeAdresse(Adresse adresse) throws Exception;
	
	Set<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception;

}
