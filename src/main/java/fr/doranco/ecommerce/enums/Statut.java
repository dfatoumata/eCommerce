package fr.doranco.ecommerce.enums;

//	Statut.DEVELOPPEUR.getStatut(); => renvoie le mot "Développeur"

public enum Statut {

	DEVELOPPEUR ("Développeur"),
	PRODUCTEUR ("Producteur"),
	VENDEUR ("Vendeur");
	
	private String statut;
	
	//Constructeur
	private Statut(String statut) {
		this.statut = statut;
	}

	public String getStatut() {
		return statut;
	}
	
}
