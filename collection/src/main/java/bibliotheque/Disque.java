package bibliotheque;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Disque implements Serializable{
	private String nom;
	private String codeBarre;
	private Set<Chanson> chansons = new HashSet<Chanson>();

//	public Disque(String nom, String codeBarre) {
//		this.nom = nom;
//		this.codeBarre = codeBarre;
//	}

	public Disque(String nom, String codeBarre, Set<Chanson> chansons) {
		this(nom, codeBarre);
		this.chansons = chansons;
	}

	public Disque(String nom, String codeBarre, Chanson... chansons) {
		this.nom = nom;
		this.codeBarre = codeBarre;
		for (Chanson c : chansons) {
			this.chansons.add(c);
		}
	}

	public String getNom() {
		return nom;
	}

	public String getCodeBarre() {
		return codeBarre;
	}

	public Set<Chanson> getChansons() {
		return chansons;
	}

	public boolean addChanson(Chanson chanson) {
		return chansons.add(chanson);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeBarre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disque other = (Disque) obj;
		return Objects.equals(codeBarre, other.codeBarre);
	}

	public int getDuree() {
		int duree = 0;
		for (Chanson chanson : chansons) {
			duree += chanson.getDuree();
		}
		return duree;
	}

}
