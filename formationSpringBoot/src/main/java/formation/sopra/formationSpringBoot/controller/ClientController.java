package formation.sopra.formationSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("clients", clientService.getAll());
		return "client/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		clientService.deleteById(id);
		return "redirect:/client";
	}

	@GetMapping("/add")
	public String create(Model model) {
		return formEdit(model, new Client());
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable Long id) {
		return formEdit(model, clientService.getById(id));
	}

	private String formEdit(Model model, Client client) {
		model.addAttribute("client", client);
		return "client/edit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Client client,Model model) {
		if(client.getId()==null) {
			clientService.create(client);
		}else {
			clientService.update(client);
		}
		return "redirect:/client";
	}

}
