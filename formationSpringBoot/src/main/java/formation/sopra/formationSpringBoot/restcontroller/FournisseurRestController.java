package formation.sopra.formationSpringBoot.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import formation.sopra.formationSpringBoot.entities.Fournisseur;
import formation.sopra.formationSpringBoot.entities.JsonViews;
import formation.sopra.formationSpringBoot.services.FournisseurService;

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

	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Fournisseur> getAll() {
		return fournisseurService.getAll();
	}

	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Fournisseur create(@Valid @RequestBody Fournisseur fournisseur, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return fournisseurService.create(fournisseur);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Fournisseur update(@Valid @RequestBody Fournisseur fournisseur, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		fournisseur.setId(id);
		return fournisseurService.update(fournisseur);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		fournisseurService.deleteById(id);
	}

}
