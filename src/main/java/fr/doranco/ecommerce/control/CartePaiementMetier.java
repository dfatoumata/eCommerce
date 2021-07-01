package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.model.dao.CartePaiementDao;
import fr.doranco.ecommerce.model.dao.ICartePaiementDao;

public class CartePaiementMetier implements ICartePaiementMetier {
    ICartePaiementDao cartePaiementDao = new CartePaiementDao();
	@Override
	public void addCartePaiement(CartePaiementDto cartePaiementDto) throws Exception {
		CartePaiement cartePaiement = new CartePaiement();
		
		
		
		cartePaiementDao.add(cartePaiement);
		
	}

	@Override
	public CartePaiement getCartePaiementById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return cartePaiementDao.get(CartePaiement.class, id);
	}


	@Override
	public void updateCartePaiement(CartePaiementDto cartePaiementDto) throws Exception {
		CartePaiement cartePaiement = new CartePaiement();
		cartePaiementDao.update(cartePaiement);
		
	}

	@Override
	public void removeCartePaiement(CartePaiementDto cartePaiementDto) throws Exception {
		CartePaiement cartePaiement = new CartePaiement();
		cartePaiementDao.remove(cartePaiement);
		
	}
	

}
