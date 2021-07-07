package fr.doranco.ecommerce.metier;

import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.dao.CartePaiementDao;
import fr.doranco.ecommerce.model.dao.ICartePaiementDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;
import fr.doranco.ecommerce.utils.CryptageDesPbeBlowfish;
import fr.doranco.ecommerce.utils.Dates;

public class CartePaiementMetier implements ICartePaiementMetier {
    ICartePaiementDao cartePaiementDao = new CartePaiementDao();
    
    
	@Override
	public void addCartePaiement(CartePaiementDto cartePaiementDto,Integer idUtilisateur) throws Exception {
		CartePaiement cartePaiement = new CartePaiement();
	
		ParamsDao paramsDao = new ParamsDao();
		Params params = paramsDao.get(Params.class, 1);
		
		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();

		
		SecretKey key = new SecretKeySpec(params.getCleCrypatage(), algorithm);
		
		byte[] numeroCrypte = CryptageDesPbeBlowfish.encrypt(algorithm, cartePaiementDto.getNumero(), key);
		cartePaiement.setNumero(numeroCrypte);
		
		byte[] cryptogrammeCrypte = CryptageDesPbeBlowfish.encrypt(algorithm, cartePaiementDto.getCryptogramme(), key);
		cartePaiement.setCryptogramme(cryptogrammeCrypte);
		
		cartePaiement.setNomProprietaire(cartePaiementDto.getNomProprietaire());
		
		cartePaiement.setPrenomProprietaire(cartePaiementDto.getPrenomProprietaire());
		
		cartePaiement.setDateFinValidite(Dates.convertStringToDateUtil(cartePaiementDto.getDateFinValidite()));
		
	    UtilisateurDao utilisateurDao = new UtilisateurDao();
		
		Utilisateur utilisateur = utilisateurDao.get(Utilisateur.class, idUtilisateur);
		
		cartePaiement.setUtilisateur(utilisateur);
		
		cartePaiementDao.add(cartePaiement);
		
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
	@Override
	public List<CartePaiement> getCarteById(Integer Id ) throws Exception {
		
		return null;
		//cartePaiementDao.get(CartePaiement.class, Id);
	}


	@Override
	public List<CartePaiement> getCartePaiementByUserId(Integer id) throws Exception {

		return cartePaiementDao.getCartePaiementByUserId(id);
	}



	@Override
	public void addCartePaiement(CartePaiementDto cartePaiementDto) throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public CartePaiement getCartePaiementById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
