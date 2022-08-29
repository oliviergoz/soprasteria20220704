package formationSpringMvc.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formationSpringMvc.model.Person;
import formationSpringMvc.model.Societe;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {

	@GetMapping("")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/person")
	public Person helloPerson() {
		Person person = new Person();
		person.setPrenom("pp");
		person.setNom("nnn");
		Societe societe = new Societe();
		societe.setNom("sss");
		person.setSociete(societe);
		return person;
	}
}
