package formation.sopra.authExercice.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import formation.sopra.authExercice.entities.Compte;
import formation.sopra.authExercice.repositories.CompteRepository;

@Controller
public class PublicController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CompteRepository compteRepo;

	@GetMapping({"","/home"})
	public String home() {
		return "public/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "public/login";
	}
	
	@GetMapping("/inscription")
	public String inscription(Model model) {
		return goInscription(new Compte(), model);
	}
	
	private String goInscription(Compte compte,Model model) {
		model.addAttribute("compte", compte);
		return "public/inscription";
	}
	
	@PostMapping("/inscription")
	public String saveCompte(@Valid @ModelAttribute Compte compte,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return goInscription(compte, model);
		}
		compte.setLogin(compte.getLogin().toLowerCase());
		compte.setPassword(passwordEncoder.encode(compte.getPass()));
		compteRepo.save(compte);
		return "redirect:/login";
	}
}
