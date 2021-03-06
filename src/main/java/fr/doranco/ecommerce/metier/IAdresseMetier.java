package fr.doranco.ecommerce.metier;

import java.util.List;
import java.util.Set;

import fr.doranco.ecommerce.entity.dto.AdresseDto;
import fr.doranco.ecommerce.entity.pojo.Adresse;

public interface IAdresseMetier {

	//CRUD
	void addAdresse(AdresseDto adresseDto, Integer idUtilisateur) throws Exception;
	Adresse getAdresseById(Integer id) throws Exception;
	void updateAdresse(AdresseDto adresseDto) throws Exception;
	void removeAdresse(Adresse adresse) throws Exception;
	
	List<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception;

}
