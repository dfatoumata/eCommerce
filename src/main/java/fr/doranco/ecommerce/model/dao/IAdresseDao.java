package fr.doranco.ecommerce.model.dao;

import java.util.Set;

import fr.doranco.ecommerce.entity.Adresse;

public interface IAdresseDao  extends IEntityFacade<Adresse>  {

	Set<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception;
	Set<String> getNomsVillesUtilisateurs() throws Exception;
}
