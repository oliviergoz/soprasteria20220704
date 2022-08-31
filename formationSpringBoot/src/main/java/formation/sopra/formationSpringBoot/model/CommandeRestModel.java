package formation.sopra.formationSpringBoot.model;

import java.util.List;

import formation.sopra.formationSpringBoot.entities.Client;

public class CommandeRestModel {
	private List<ElementPanierRestModel> panier;
	private Client client;

	public CommandeRestModel() {

	}

	public List<ElementPanierRestModel> getPanier() {
		return panier;
	}

	public void setPanier(List<ElementPanierRestModel> panier) {
		this.panier = panier;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
