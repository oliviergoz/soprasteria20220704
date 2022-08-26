package formationSpringMvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eshop.entities.Produit;
import eshop.services.FournisseurService;
import eshop.services.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private ProduitService produitService;
	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("produits", produitService.getAll());
		return "produit/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		produitService.deleteById(id);
		return "redirect:/produit";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		return goForm(produitService.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Produit(), model);
	}

	private String goForm(Produit produit, Model model) {
		model.addAttribute("fournisseurs", fournisseurService.getAll());
		model.addAttribute("produit", produit);
		return "produit/edit";
	}

	@PostMapping("")
	public String save(@Valid @ModelAttribute Produit produit, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goForm(produit, model);
		}
		if (produit.getFournisseur().getId() == null) {
			produit.setFournisseur(null);
		}

		if (produit.getId() == null) {
			produitService.create(produit);
		} else {
			produitService.update(produit);
		}
		return "redirect:/produit";
	}
}
