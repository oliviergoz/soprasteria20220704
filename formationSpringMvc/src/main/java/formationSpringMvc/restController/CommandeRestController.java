package formationSpringMvc.restController;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.entities.Client;
import eshop.entities.Commande;
import eshop.entities.JsonViews;
import eshop.entities.Produit;
import eshop.services.ClientService;
import eshop.services.CommandeService;
import formationSpringMvc.model.CommandeRestModel;

@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ClientService clientService;

//	@PostMapping("")
//	public Commande create(Client client, Map<Produit, Integer> panier) {
//		return commandeService.create(panier, client);
//	}

	@PostMapping("")
	@JsonView(JsonViews.Commande.class)
	public Commande create(@RequestBody CommandeRestModel commande) {
		return commandeService.create(
				commande.getPanier().stream().collect(Collectors.toMap(e -> e.getProduit(), e -> e.getQuantite())),
				commande.getClient());
	}

	@PostMapping("/commande")
	@JsonView(JsonViews.Commande.class)
	public Commande create(@RequestBody Commande commande) {
		return commandeService.create(commande);
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.CommandeDetails.class)
	public Commande getById(@PathVariable Long id) {
		return commandeService.getById(id);
	}

}
