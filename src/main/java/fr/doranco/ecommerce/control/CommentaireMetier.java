package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.pojo.Commentaire;
import fr.doranco.ecommerce.model.dao.ICommentaireDao;

public class CommentaireMetier implements ICommentaireMetier {

	ICommentaireDao commentaireDao = new CommentaireDao();
	@Override
	public void addCommentaire(Commentaire commentaire) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commentaire getCommentaireById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commentaire getCommentaireByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCommentaire(Commentaire commentaire) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCommentaire(Commentaire commentaire) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
