package formationJpa.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
@SequenceGenerator(name = "seqFormation", sequenceName = "seq_formation", allocationSize = 1, initialValue = 100)
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqFormation")
	private Long id;
	@Column(name="nom")
	private String nom;
	@Column(name="date_formation")
	private LocalDate date;

	public Formation() {

	}

	public Formation(String nom, LocalDate date) {
		this.nom = nom;
		this.date = date;
	}

	public Formation(String nom) {
		this(nom, LocalDate.now());
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
		Formation other = (Formation) obj;
		return Objects.equals(id, other.id);
	}

}