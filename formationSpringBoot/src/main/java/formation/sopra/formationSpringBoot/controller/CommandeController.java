package formation.sopra.formationSpringBoot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.entities.Commande;
import formation.sopra.formationSpringBoot.entities.Produit;
import formation.sopra.formationSpringBoot.services.ClientService;
import formation.sopra.formationSpringBoot.services.CommandeService;
import formation.sopra.formationSpringBoot.services.ProduitService;

@Controller
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CommandeService commandeService;

	@GetMapping("/panier")
	public String panier(Model model) {
		model.addAttribute("produits", produitService.getAll());
		return "commande/panier";
	}

	@GetMapping("/add/{id}")
	public String add(Model model, @PathVariable Long id, HttpSession session) {
		if (session.getAttribute("panier") == null) {
			session.setAttribute("panier", new HashMap<Produit, Integer>());
		}
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		Produit produit = produitService.getById(id);
		panier.put(produit, panier.get(produit) != null ? panier.get(produit) + 1 : 1);
		return "redirect:/commande/panier";
	}

	@GetMapping("/remove/{id}")
	public String remove(Model model, @PathVariable Long id, HttpSession session) {
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		Produit produit = produitService.getById(id);
		if (panier.get(produit) - 1 > 0) {
			panier.put(produit, panier.get(produit) - 1);
		} else {
			panier.remove(produit);
		}
		return "redirect:/commande/panier";
	}

	@GetMapping("/validation")
	public String valider(Model model) {
		model.addAttribute("clients", clientService.getAll());
		return "commande/valid";
	}

	@PostMapping("/validation")
	public String saveCommande(@RequestParam Long id, HttpSession session, Model model) {
		Client client = clientService.getById(id);
		Commande commande = commandeService.create((Map<Produit, Integer>) session.getAttribute("panier"), client);
		session.removeAttribute("panier");
		model.addAttribute("message", "commande " + commande.getNumero() + " pour le client "
				+ commande.getClient().getPrenom() + " " + commande.getClient().getNom() + " creee");
		return "commande/recap";
	}
}
