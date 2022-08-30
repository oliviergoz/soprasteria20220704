package eshop.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@MappedSuperclass
public abstract class Personne {
	@JsonView(JsonViews.Base.class)
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	@JsonView(JsonViews.Base.class)
	private String nom;
	@JsonView(JsonViews.Base.class)
	@Email
	@NotEmpty
	private String mail;

	public Personne() {

	}

	public Personne(String prenom, String nom, String mail) {
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
