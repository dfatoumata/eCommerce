package fr.doranco.ecommerce.metier;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.dto.UtilisateurDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.dao.CartePaiementDao;
import fr.doranco.ecommerce.model.dao.ICartePaiementDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.utils.CryptageDesPbeBlowfish;
import fr.doranco.ecommerce.utils.Dates;

public class CartePaiementMetier implements ICartePaiementMetier {
    ICartePaiementDao cartePaiementDao = new CartePaiementDao();
	@Override
	public void addCartePaiement(CartePaiementDto cartePaiementDto) throws Exception {
		CartePaiement cartePaiement = new CartePaiement();
	
		ParamsDao paramsDao = new ParamsDao();
		Params params = paramsDao.get(Params.class, 1);
		
		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();

		
		SecretKey key = new SecretKeySpec(params.getCleCrypatage(), algorithm);
		
		byte[] numeroCrypte = CryptageDesPbeBlowfish.encrypt(algorithm, cartePaiementDto.getNumero(), key);
		cartePaiement.setNumero(numeroCrypte);
		
		
		@Override
	
		
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
