package formation.sopra.formationSpringBoot.restcontroller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSpringBoot.entities.Commande;
import formation.sopra.formationSpringBoot.entities.JsonViews;
import formation.sopra.formationSpringBoot.model.CommandeRestModel;
import formation.sopra.formationSpringBoot.services.ClientService;
import formation.sopra.formationSpringBoot.services.CommandeService;

@RestController
@RequestMapping("/api/commande")
@CrossOrigin(origins = "*")
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
