package formationJpaSpring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "video")
@SequenceGenerator(name = "seqMateriel", sequenceName = "seq_video", initialValue = 100, allocationSize = 1)
public class Videoprojecteur extends Materiel {
	@Enumerated(EnumType.STRING)
	@Column(name = "resolution", length = 6)
	private Resolution resolution;
	private boolean hd;

	public Videoprojecteur() {

	}

	public Videoprojecteur(Resolution resolution) {
		this.resolution = resolution;
		this.hd = !this.resolution.equals(Resolution.SD);
	}

	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	public boolean isHd() {
		return hd;
	}

	public void setHd(boolean hd) {
		this.hd = hd;
	}

}
