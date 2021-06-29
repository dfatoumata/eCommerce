package fr.doranco.ecommerce.enums;

public enum Ville {

	PARIS ("Paris"),
	LYON ("Lyon"),
	MARSEILLE ("Marseille"),
	AIX_EN_PROVENCE ("Aix-En-Provence");
	
	private String ville;
	
	private Ville(String ville) {
		this.ville = ville;
	}
	
	public String getVille() {
		return this.ville;
	}
}
