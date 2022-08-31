package centerpark.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "vehicule")

public class Vehicule {

	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicule")
	private Integer id;
	@JsonView(JsonViews.Common.class)
	private String model;
	@OneToMany(mappedBy = "vehicule")
	@JsonView(JsonViews.VehiculeWithSafari.class)
	private List<Safari> safaris;
	// @JsonIgnore
	@Version
	private int version;

	public Vehicule() {
	}

	public Vehicule(String model) {
		this.model = model;
	}

	public Vehicule(Integer id, String model) {
		this.id = id;
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Safari> getSafaris() {
		return safaris;
	}

	public void setSafaris(List<Safari> safaris) {
		this.safaris = safaris;
	}

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", model=" + model + "]";
	}

	public String getInfo() {
		return id + " " + model;
	}

}
