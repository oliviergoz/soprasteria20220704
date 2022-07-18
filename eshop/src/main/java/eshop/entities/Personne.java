package eshop.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Personne {
	private String prenom;
	private String nom;
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
