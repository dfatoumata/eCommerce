package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;


public class UtilisateurMetier implements IUtilisateurMetier {

	
	UtilisateurDao utilisateurDao = new UtilisateurDao(); 
	
	@Override
	public void addUtilisateur(Utilisateur utilisateur) throws Exception {
		
		utilisateur.setNom(utilisateur.getNom().toUpperCase());
		
		utilisateur.setPrenom(utilisateur.getPrenom().substring(0, 1).toUpperCase()
				.concat(utilisateur.getPrenom().substring(1).toLowerCase()));
		
		utilisateurDao.add(utilisateur);
	}

	@Override
	public Utilisateur getUtilisateurById(Integer id) throws Exception {
		// utilisateurDao.getUtilisateurById(id);
		return null;
	}

	@Override
	public Utilisateur getUtilisateurByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return utilisateurDao.getUtilisateurByEmail(email);
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws Exception {
		
		utilisateur.setNom(utilisateur.getNom().toUpperCase());
		
		utilisateur.setPrenom(utilisateur.getPrenom().substring(0, 1).toUpperCase()
				.concat(utilisateur.getPrenom().substring(1).toLowerCase()));
		
		 utilisateurDao.update(utilisateur);

	}

	@Override
	public void removeUtilisateur(Utilisateur utilisateur) throws Exception {
		utilisateurDao.remove(utilisateur);

	}

	@Override
	public List<Utilisateur> getUtilisateurs() throws Exception {
		return utilisateurDao.getAll(Utilisateur.class);
	}

	@Override
	public List<Utilisateur> getUtilisateursByVille(String ville) throws Exception {
		return utilisateurDao.getUtilisateursByVille(ville);
	}

}
