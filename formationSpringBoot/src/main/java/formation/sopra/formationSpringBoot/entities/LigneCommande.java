package formation.sopra.formationSpringBoot.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="ligne_commande")
public class LigneCommande {
	@EmbeddedId
	@JsonView(JsonViews.CommandeDetails.class)
	private LigneCommandeKey id;
	@Column(name="ligne_commande_quantite")
	@JsonView(JsonViews.CommandeDetails.class)
	private int quantite;
	
	public LigneCommande() {
		
	}

	public LigneCommande(LigneCommandeKey id, int quantite) {
		this.id = id;
		this.quantite = quantite;
	}

	public LigneCommandeKey getId() {
		return id;
	}

	public void setId(LigneCommandeKey id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
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
		LigneCommande other = (LigneCommande) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
