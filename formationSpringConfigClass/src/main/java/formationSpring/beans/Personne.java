package formationSpring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("olivier")
public class Personne implements IPersonne, Presentation {
	private String prenom = "olivier";
	@Autowired
	@Qualifier("lille")
	private Adresse adresse;

	public Personne() {

	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String sePresenter() {
		System.out.println("dans la methode se presenter");
		//throw new IllegalArgumentException("une execption");
		return "bonjour je m'appelle " + getPrenom();
	}

}
