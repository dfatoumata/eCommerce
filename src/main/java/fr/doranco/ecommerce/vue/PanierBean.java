package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.metier.IPanierMetier;
import fr.doranco.ecommerce.metier.PanierMetier;

@ManagedBean(name = "panierBean")
@SessionScoped
public class PanierBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = " ";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = " ";

	Utilisateur user = LoginBean.getConnectedUser();

	public PanierBean() {
	}

	public List<ArticlePanier> afficherPanierByUser() {
		IPanierMetier panierMetier = new PanierMetier();
		List<ArticlePanier> articlePaniers = null;

		try {
			articlePaniers = panierMetier.getPanierByUser(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return articlePaniers;
	}

	public String supprimerArticlePanier(ArticlePanier articlePanier) {
		user.getPanier().remove(articlePanier);
		IPanierMetier panierMetier = new PanierMetier();

		try {
			panierMetier.removeArticlePanier(articlePanier);
			;
			messageSuccess = "Article supprimé avec succès du panier";
			// afficher un popup indiquant que l'article a été ajouté au panier
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
