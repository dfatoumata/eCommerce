package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.dto.UtilisateurDto;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;

public interface IUtilisateurMetier {

	//CRUD
	void addUtilisateur(UtilisateurDto utilisateurDto) throws Exception;
	UtilisateurDto getUtilisateurById(Integer id) throws Exception;
	UtilisateurDto getUtilisateurByEmail(String email) throws Exception;
	void updateUtilisateur(UtilisateurDto utilisateurDto) throws Exception;
	void removeUtilisateur(UtilisateurDto utilisateurDto) throws Exception;
	
	List<UtilisateurDto> getUtilisateurs() throws Exception;
	List<UtilisateurDto> getUtilisateursByVille(String ville) throws Exception;
	void updateUtilisateur(Utilisateur utilisateur) throws Exception;

}
