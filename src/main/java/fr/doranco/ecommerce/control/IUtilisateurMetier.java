package fr.doranco.ecommerce.control;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Utilisateur;

public interface IUtilisateurMetier {

	//CRUD
	void addUtilisateur(Utilisateur utilisateur) throws Exception;
	Utilisateur getUtilisateurById(Integer id) throws Exception;
	Utilisateur getUtilisateurByEmail(String email) throws Exception;
	void updateUtilisateur(Utilisateur utilisateur) throws Exception;
	void removeUtilisateur(Utilisateur utilisateur) throws Exception;
	
	List<Utilisateur> getUtilisateurs() throws Exception;
	List<Utilisateur> getUtilisateursByVille(String ville) throws Exception;

}
