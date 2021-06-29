package fr.doranco.ecommerce.enums;

public enum Mois {
	
	JANVIER ("Janvier"),
	FEVRIER ("Février"),
	MARS ("Mars"),
	AVRIL ("Avril"),
	MAI ("Mai"),
	JUIN ("Juin"),
	JUILLET ("Juillet"),
	AOUT ("Août"),
	SEPTEMBRE ("Septembre"),
	OCTOBRE ("Octobre"),
	NOVEMBRE ("Novembre"),
	DECEMBRE ("Décembre");
	
	private String mois;
	
	private Mois(String mois) {
		this.mois = mois;
	}
	
	public String getMois() {
		return this.mois;
	}
}
