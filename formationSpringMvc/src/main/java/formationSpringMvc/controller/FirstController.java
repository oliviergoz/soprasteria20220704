package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam String prenom,Model model) {
		model.addAttribute("prenom", prenom);
		return "hello";
	}

	@GetMapping("/hello/{id}")
	public String pathVariable(@PathVariable Integer id, @RequestParam String prenom) {
		return "hello";
	}

	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}
}
