package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.Commentaire;

public interface ICommentaireMetier {

	void addCommentaire(Commentaire commentaire) throws Exception;
	Commentaire getCommentaireById(Integer id) throws Exception;
	Commentaire getCommentaireByEmail(String email) throws Exception;
	void updateCommentaire(Commentaire commentaire) throws Exception;
	void removeCommentaire(Commentaire commentaire) throws Exception;
}
