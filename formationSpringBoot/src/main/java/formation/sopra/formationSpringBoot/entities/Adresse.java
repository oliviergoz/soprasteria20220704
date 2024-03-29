package formation.sopra.formationSpringBoot.entities;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	@JsonView(JsonViews.Base.class)
	private String numero;
	@JsonView(JsonViews.Base.class)
	private String rue;
	@JsonView(JsonViews.Base.class)
	private String codePostal;
	@JsonView(JsonViews.Base.class)
	private String ville;

	public Adresse() {

	}

	public Adresse(String numero, String rue, String codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdresseComplete() {
		return numero + " " + rue + " " + codePostal + " " + ville;
	}

}
