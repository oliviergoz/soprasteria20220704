package formationSpringMvc.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.entities.Fournisseur;
import eshop.entities.JsonViews;
import eshop.services.FournisseurService;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {

	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Fournisseur getById(@PathVariable Long id) {
		return fournisseurService.getById(id);
	}

	@GetMapping("/{id}/produits")
	@JsonView(JsonViews.FournisseurWithProduits.class)
	public Fournisseur getByIdWithProduits(@PathVariable Long id) {
		return fournisseurService.getByIdWithProduits(id);
	}

}
