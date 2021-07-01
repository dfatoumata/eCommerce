package fr.doranco.ecommerce.control;

import java.util.Set;

import javax.persistence.Convert;

import fr.doranco.ecommerce.entity.dto.AdresseDto;
import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.model.dao.AdresseDao;
import fr.doranco.ecommerce.model.dao.IAdresseDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;


public class AdresseMetier implements IAdresseMetier {

	IAdresseDao adresseDao = new AdresseDao();
	
	public AdresseMetier() {
	}
	
	@Override
	public void addAdresse(AdresseDto adresseDto, Integer idUtilisateur) throws Exception {
		Adresse adresse = new Adresse();
		
		adresse.setNumero(Integer.parseInt(adresseDto.getNumero()));
		adresse.setVille(adresseDto.getRue().toUpperCase());
		adresse.setVille(adresseDto.getVille().toUpperCase());
		adresse.setCodePostal(adresseDto.getCodePostal());
		UtilisateurDao utilisateurDao = new UtilisateurDao();
		
		Utilisateur utilisateur = utilisateurDao.get(Utilisateur.class, idUtilisateur);
		
		adresse.setUtilisateur(utilisateur);
		
		adresseDao.add(adresse);
	}

	@Override
	public Adresse getAdresseById(Integer id) throws Exception {
		return adresseDao.get(Adresse.class, id);
	}

	@Override
	public void updateAdresse(AdresseDto adresseDto) throws Exception {
		Adresse adresse = new Adresse();
		
		adresseDao.update(adresse);
	}

	@Override
	public void removeAdresse(Adresse adresse) throws Exception {
		adresseDao.remove(adresse);
	}

	@Override
	public Set<Adresse> getAdressesUtilisateur(Integer idUtilisateur) throws Exception {
		//adresseDao.getAdressesUtilisateur(idUtilisateur);
		return null;
	}

}
