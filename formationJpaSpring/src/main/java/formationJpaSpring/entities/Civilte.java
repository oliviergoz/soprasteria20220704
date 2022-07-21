package formationJpaSpring.entities;

public enum Civilte {

	M("monsieur"), MME("madame"), MLLE("mademoiselle");

	private String titre;

	private Civilte(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}
}
