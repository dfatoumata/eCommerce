package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.model.dao.CartePaiementDao;
import fr.doranco.ecommerce.model.dao.ICartePaiementDao;

public class CartePaiementMetier implements ICartePaiementMetier {
    ICartePaiementDao cartePaiementDao = new CartePaiementDao();
	@Override
	public void addCartePaiement(CartePaiement cartePaiement) throws Exception {
		cartePaiementDao.add(cartePaiement);
		
	}

	@Override
	public CartePaiement getCartePaiementById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return cartePaiementDao.get(CartePaiement.class, id);
	}


	@Override
	public void updateCartePaiement(CartePaiement cartePaiement) throws Exception {
		cartePaiementDao.update(cartePaiement);
		
	}

	@Override
	public void removeCartePaiement(CartePaiement cartePaiement) throws Exception {
		cartePaiementDao.remove(cartePaiement);
		
	}
	

}
