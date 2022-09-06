package formation.sopra.formationSpringBoot.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSpringBoot.entities.JsonViews;
import formation.sopra.formationSpringBoot.entities.Produit;
import formation.sopra.formationSpringBoot.services.ProduitService;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin(origins = "*")
public class ProduitRestController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit getById(@PathVariable Long id) {
		return produitService.getById(id);
	}

	@GetMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public List<Produit> getAll() {
		return produitService.getAll();
	}

	@JsonView(JsonViews.ProduitWithFournisseur.class)
	@PostMapping("")
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return produitService.create(produit);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit update(@PathVariable Long id, @Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		produit.setId(id);
		return produitService.update(produit);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produitService.deleteById(id);
	}
}
