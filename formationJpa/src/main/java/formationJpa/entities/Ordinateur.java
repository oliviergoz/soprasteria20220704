package formationJpa.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pc")
@SequenceGenerator(name = "seqMateriel", sequenceName = "seq_pc", allocationSize = 1, initialValue = 100)
public class Ordinateur extends Materiel {
	@Enumerated(EnumType.ORDINAL)
	private Ram ram;

	public Ordinateur() {

	}

	public Ordinateur(Ram ram) {
		this.ram = ram;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

}
