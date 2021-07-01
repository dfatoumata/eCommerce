package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;

public interface ICartePaiementMetier {

	
	void addCartePaiement(CartePaiementDto cartePaiementDto) throws Exception;
	CartePaiement getCartePaiementById(Integer id) throws Exception;
	void updateCartePaiement(CartePaiementDto cartePaiementDto) throws Exception;
	void removeCartePaiement(CartePaiementDto cartePaiementDto) throws Exception;
	
}
