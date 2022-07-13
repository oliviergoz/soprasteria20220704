package formationJpa.entities;

public enum Resolution {
	SD("720*480"), HD("1280*720"), FULLHD("1920*1080"), UHD("3840*2160");

	private String libelle;

	private Resolution(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

}
