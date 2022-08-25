package formationSpringMvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formationSpringMvc.model.Person;

@Controller
@RequestMapping("/form")
public class Exo1Controller {

	@GetMapping("")
	public String formulaire() {
		return "exo1/form";
	}

	@PostMapping("")
	public String hello(@ModelAttribute Person personne, Model model,HttpSession session) {
		session.setAttribute("unTrucEnSession", "un truc en session");
		System.out.println(personne.getSociete());
		model.addAttribute("personne", personne);
		return "exo1/hello";
	}

//	public String hello(@RequestParam String prenom,@RequestParam(name = "nom", required = true, defaultValue = "world") String nom, Model model) {
//		Person p=new Person();
//		p.setNom(nom);
//		p.setPrenom(prenom);
//		model.addAttribute("personne", p);
//		return "exo1/hello";
//	}

}
