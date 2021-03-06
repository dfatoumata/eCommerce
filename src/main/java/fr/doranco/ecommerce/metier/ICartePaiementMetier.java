package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;

public interface ICartePaiementMetier {

	

	void addCartePaiement(CartePaiementDto cartePaiementDto,Integer idUtilisateur) throws Exception;
	List<CartePaiement> getCarteById(Integer Id )throws Exception;

	void addCartePaiement(CartePaiementDto cartePaiementDto) throws Exception;
	CartePaiement getCartePaiementById(Integer id) throws Exception;
	List<CartePaiement> getCartePaiementByUserId(Integer id) throws Exception;

	void updateCartePaiement(CartePaiementDto cartePaiementDto) throws Exception;
	void removeCartePaiement(CartePaiementDto cartePaiementDto) throws Exception;
	
	
}
