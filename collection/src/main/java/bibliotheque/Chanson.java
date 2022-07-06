package bibliotheque;

import java.io.Serializable;
import java.util.Objects;

public class Chanson implements Serializable {
	private String nom;
	private int duree;

	public Chanson(String nom, int duree) {
		this.nom = nom;
		this.duree = duree;
	}

	public String getNom() {
		return nom;
	}

	public int getDuree() {
		return duree;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duree, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chanson other = (Chanson) obj;
		return duree == other.duree && Objects.equals(nom, other.nom);
	}

}
