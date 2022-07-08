package formationJdbc.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

	private Long id;
	private String nom;
	private LocalDate embauche;
	private Departement departement;

	public Employee(Long id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Employee() {

	}

	public Employee(String nom) {
		this.nom = nom;
	}

	public Employee(String nom, Departement departement) {
		this.nom = nom;
		this.departement = departement;
	}

	public Employee(Long id, String nom, Departement departement) {
		this.id = id;
		this.nom = nom;
		this.departement = departement;
	}

	public LocalDate getEmbauche() {
		return embauche;
	}

	public void setEmbauche(LocalDate embauche) {
		this.embauche = embauche;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
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
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}

}
