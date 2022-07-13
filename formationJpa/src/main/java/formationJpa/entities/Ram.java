package formationJpa.entities;

public enum Ram {
	GO8("8 Go"), GO16("16 Go"), GO32("32 Go");

	private String libelle;

	private Ram(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
