package fr.doranco.ecommerce.enums;

public enum Mois {
	
	JANVIER ("Janvier"),
	FEVRIER ("F�vrier"),
	MARS ("Mars"),
	AVRIL ("Avril"),
	MAI ("Mai"),
	JUIN ("Juin"),
	JUILLET ("Juillet"),
	AOUT ("Ao�t"),
	SEPTEMBRE ("Septembre"),
	OCTOBRE ("Octobre"),
	NOVEMBRE ("Novembre"),
	DECEMBRE ("D�cembre");
	
	private String mois;
	
	private Mois(String mois) {
		this.mois = mois;
	}
	
	public String getMois() {
		return this.mois;
	}
}
