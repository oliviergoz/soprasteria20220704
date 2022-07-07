package formationJdbc.model;

import java.util.Objects;

public class Departement {
	private Long id;
	private String nom;

	public Departement() {

	}

	public Departement(Long id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Departement(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departement other = (Departement) obj;
		return Objects.equals(id, other.id);
	}

}
