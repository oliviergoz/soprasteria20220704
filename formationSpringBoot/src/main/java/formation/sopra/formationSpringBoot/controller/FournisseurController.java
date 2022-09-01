package formation.sopra.formationSpringBoot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.sopra.formationSpringBoot.entities.Fournisseur;
import formation.sopra.formationSpringBoot.entities.Utilisateur;
import formation.sopra.formationSpringBoot.services.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	private Logger LOGGER=LoggerFactory.getLogger(FournisseurController.class);
	
	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("")
	public String list(Model model,@AuthenticationPrincipal Utilisateur utilisateur) {
		model.addAttribute("fournisseurs", fournisseurService.getAll());
		LOGGER.info(utilisateur.getUsername());
		return "fournisseur/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		return goForm(model, fournisseurService.getById(id));
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(model, new Fournisseur());
	}

	private String goForm(Model model, Fournisseur fournisseur) {
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseur/edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		fournisseurService.deleteById(id);
		model.addAttribute("delete", "fournisseur " + id + " supprime");
		return "redirect:/fournisseur";
	}

	@PostMapping("")
	public String save(@ModelAttribute Fournisseur fournisseur, Model model) {
		if (fournisseur.getId() == null) {
			fournisseur = fournisseurService.create(fournisseur);
			model.addAttribute("createOrUpdate", "fournisseur " + fournisseur.getId() + " cree");
		} else {
			fournisseurService.update(fournisseur);
			model.addAttribute("createOrUpdate", "fournisseur " + fournisseur.getId() + " modifie");
		}
		return "redirect:/fournisseur";
	}
}
