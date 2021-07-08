package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.metier.AdresseMetier;
import fr.doranco.ecommerce.metier.CartePaiementMetier;
import fr.doranco.ecommerce.metier.IAdresseMetier;
import fr.doranco.ecommerce.metier.ICartePaiementMetier;

@ManagedBean(name = "ajouterCommandeBean")
@SessionScoped
public class AjouterCommandeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	@ManagedProperty(name = "numero", value = "")
	private String numero;

	@ManagedProperty(name = "rue", value = "")
	private String rue;

	@ManagedProperty(name = "ville", value = "")
	private String ville;

	@ManagedProperty(name = "code_postal", value = "")
	private String code_postal;

	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = " ";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = " ";

	Utilisateur user = LoginBean.getConnectedUser();

	Commande commande = new Commande();

//	private List<Double> total_article_panier ;

	public AjouterCommandeBean() {
	}
	public Double getTotalGenereal() {
		Double totalGeneral = 0.0;
		for (Double totalArticlePanier : getTotalArticlePanier()) {
			totalGeneral += totalArticlePanier;

		}
		return totalGeneral;
	}
//	public Double getTotalGenereal() {
//		Double totalGeneral = 0.0;
//		for (Double totalArticlePanier : getTotalArticlePanier().values()) {
//			totalGeneral += totalArticlePanier;
//
//		}
//		return totalGeneral;
//	}
	
//	public Map<ArticlePanier ,Double> getTotalArticlePanier() {
//		
//		Map<ArticlePanier ,Double> listeTotalParArticlePanier = new HashMap<ArticlePanier, Double>();
//		for (ArticlePanier articlePanier : user.getPanier()) {
//			Double prixRemiseCategorie = articlePanier.getArticle().getPrix()
//					* (1 - (articlePanier.getArticle().getCategorie().getRemise() / 100));
////			Double prixRemiseCategorie = articlePanier.getArticle().getPrix() - (articlePanier.getArticle().getPrix()
////					* (articlePanier.getArticle().getCategorie().getRemise() / 100));
//			Double prixRemiseArticle = prixRemiseCategorie * (1 - (articlePanier.getArticle().getRemise() / 100));
//
//			Double prixFinal = articlePanier.getQuantite() * prixRemiseArticle;
//			listeTotalParArticlePanier.put(articlePanier, prixFinal);
//
//		}
//		return listeTotalParArticlePanier;
//	}

	public List<Double> getTotalArticlePanier() {
		List<Double> listeTotal = new ArrayList<Double>();
		for (ArticlePanier articlePanier : user.getPanier()) {
			Double prixRemiseCategorie = articlePanier.getArticle().getPrix()
					* (1 - (articlePanier.getArticle().getCategorie().getRemise() / 100));
//			Double prixRemiseCategorie = articlePanier.getArticle().getPrix() - (articlePanier.getArticle().getPrix()
//					* (articlePanier.getArticle().getCategorie().getRemise() / 100));
			Double prixRemiseArticle = prixRemiseCategorie * (1 - (articlePanier.getArticle().getRemise() / 100));

			Double prixFinal = articlePanier.getQuantite() * prixRemiseArticle;
			listeTotal.add(prixFinal);
		}
		return listeTotal;
	}

	public String passerCommande() {

		return "";

	}

	public String ajouterAdresseFacturation(Adresse adresse) {

		commande.setAdresseFacturation(adresse);
		return "";

	}

	public String ajouterAdresseLivraison(Adresse adresse) {
		commande.setAdresseLivraison(adresse);
		return "";
	}

	public String ajouterCartePaiement(CartePaiement cartePaiement) {
		commande.setCartePaiementDefaut(cartePaiement);
		;
		return "";
	}

	public List<CartePaiement> getCartes() {

		ICartePaiementMetier cartePaiementMetier = new CartePaiementMetier();
		List<CartePaiement> cartePaiements = new ArrayList<CartePaiement>();
		try {
			cartePaiements = cartePaiementMetier.getCartePaiementByUserId(user.getId());
		} catch (Exception e) {
			messageError = "Erreur technique ! Veuillez réessayer plus tard.\n" + e.getMessage();
			e.printStackTrace();
		}

		return cartePaiements;
	}

	public List<Adresse> getAdresses() {

		IAdresseMetier adresseMetier = new AdresseMetier();
		List<Adresse> adresses = new ArrayList<Adresse>();
		try {
			adresses = adresseMetier.getAdressesUtilisateur(user.getId());
		} catch (Exception e) {
			messageError = "Erreur technique ! Veuillez réessayer plus tard.\n" + e.getMessage();
			e.printStackTrace();
		}

		return adresses;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getId() {
		return id;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setId(String id) {
		this.id = id;
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
