package fr.doranco.ecommerce.metier;

import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.ecommerce.entity.dto.UtilisateurDto;
import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.enums.TypeUtilisateur;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;
import fr.doranco.ecommerce.utils.CryptageDesPbeBlowfish;
import fr.doranco.ecommerce.utils.Dates;


public class UtilisateurMetier implements IUtilisateurMetier {

	
	UtilisateurDao utilisateurDao = new UtilisateurDao(); 
	
	@Override
	public void addUtilisateur(UtilisateurDto utilisateurDto) throws Exception {
		
		ParamsDao paramsDao = new ParamsDao();
		Params params = paramsDao.get(Params.class, 1);
		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();

		
		SecretKey key = new SecretKeySpec(params.getCleCrypatage(), algorithm);
		
		byte[] motDePasseCrypte = CryptageDesPbeBlowfish.encrypt(algorithm, utilisateurDto.getPassword(), key);
		
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setNom(utilisateurDto.getNom().toUpperCase());
		
		utilisateur.setPrenom(utilisateurDto.getPrenom().substring(0, 1).toUpperCase()
				.concat(utilisateurDto.getPrenom().substring(1).toLowerCase()));
		
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setPassword(motDePasseCrypte);
		utilisateur.setGenre(utilisateurDto.getGenre());
		utilisateur.setDateNaissance(Dates.convertStringToDateUtil(utilisateurDto.getDateNaissance()));
		
		if (utilisateurDto.getTelephone() != null) {
			utilisateur.setTelephone(utilisateurDto.getTelephone());
		}	
		utilisateur.setProfil(utilisateurDto.getProfil());
		utilisateur.setIsActif(true);
		


		
		utilisateurDao.add(utilisateur);
	}

	@Override
	public UtilisateurDto getUtilisateurById(Integer id) throws Exception {
		// utilisateurDao.getUtilisateurById(id);
		return null;
	}

	@Override
	public UtilisateurDto getUtilisateurByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return utilisateurDao.getUtilisateurByEmail(email);
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws Exception {
		
		 utilisateurDao.update(utilisateur);

	}

	@Override²	
	public void removeUtilisateur(UtilisateurDto utilisateurDto) throws Exception {
		
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
