package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.CartePaiement;

public interface ICartePaiementMetier {

	
	void addCartePaiement(CartePaiement cartePaiement) throws Exception;
	CartePaiement getCartePaiementById(Integer id) throws Exception;
	void updateCartePaiement(CartePaiement cartePaiement) throws Exception;
	void removeCartePaiement(CartePaiement cartePaiement) throws Exception;
	
}
