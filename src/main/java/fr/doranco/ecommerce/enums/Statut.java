package fr.doranco.ecommerce.enums;

//	Statut.DEVELOPPEUR.getStatut(); => renvoie le mot "D�veloppeur"

public enum Statut {

	DEVELOPPEUR ("D�veloppeur"),
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
