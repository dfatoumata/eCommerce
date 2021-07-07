package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;

public interface ICartePaiementDao extends IEntityFacade<CartePaiement> {
	
	List<CartePaiement> getCartePaiementByUserId(Integer id) throws Exception ;

}
