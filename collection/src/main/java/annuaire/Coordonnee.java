package annuaire;

import java.util.Objects;

public class Coordonnee {
	private String telephone;
	private Adresse adresse;

	public Coordonnee(String telephone, Adresse adresse) {
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public Coordonnee() {

	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnee other = (Coordonnee) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(telephone, other.telephone);
	}

}
