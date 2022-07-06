package fichier;

import java.io.Serializable;
import java.util.Objects;

public class Personne implements Serializable{
	private static Long auto = 100L;
	private Long id;
	private String prenom;
	private String nom;

	public Personne(String prenom, String nom) {
		this.id = auto;
		this.prenom = prenom;
		this.nom = nom;
		auto++;
	}

	public Personne() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id);
	}

}
