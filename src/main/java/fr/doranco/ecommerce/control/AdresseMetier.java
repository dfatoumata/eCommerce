package fr.doranco.ecommerce.control;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.model.dao.AdresseDao;
import fr.doranco.ecommerce.model.dao.IAdresseDao;


public class AdresseMetier implements IAdresseMetier {

	IAdresseDao adresseDao = new AdresseDao();
	
	public AdresseMetier() {
	}
	
	@Override
	public void addAdresse(Adresse adresse, Integer idUtilisateur) throws Exception {
		adresse.setVille(adresse.getVille().toUpperCase());
		adresseDao.add(adresse);
	}

	@Override
	public Adresse getAdresseById(Integer id) throws Exception {
		return adresseDao.get(Adresse.class, id);
	}

	@Override
	public void updateAdresse(Adresse adresse) throws Exception {
		adresseDao.update(adresse);
	}

	@Override
	public void removeAdresse(Adresse adresse) throws Exception {
		adresseDao.remove(adresse);
	}

	@Override
	public Set<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception {
		return adresseDao.getAdressesUtilisateur(idUtilisateur);
	}

}
