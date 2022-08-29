package formationSpringMvc.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.entities.JsonViews;
import eshop.entities.Produit;
import eshop.services.ProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit getById(@PathVariable Long id) {
		return produitService.getById(id);
	}
}
