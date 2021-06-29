package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Adresse;

public interface IAdresseDao  extends IEntityFacade<Adresse>  {

	List<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception;
	List<String> getNomsVillesUtilisateurs() throws Exception;
}
