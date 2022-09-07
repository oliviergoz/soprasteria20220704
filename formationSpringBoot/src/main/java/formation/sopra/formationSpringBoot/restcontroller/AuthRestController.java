package formation.sopra.formationSpringBoot.restcontroller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSpringBoot.entities.JsonViews;
import formation.sopra.formationSpringBoot.entities.Role;
import formation.sopra.formationSpringBoot.entities.Utilisateur;
import formation.sopra.formationSpringBoot.repositories.UtilisateurRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	private final static Logger LOGGER=LoggerFactory.getLogger(AuthRestController.class);
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public Utilisateur auth(@AuthenticationPrincipal Utilisateur utilisateur) {
		LOGGER.info(utilisateur.getLogin());
		return utilisateur;
	}
	
	@PostMapping("/inscription")
	@JsonView(JsonViews.Base.class)
	public Utilisateur inscription(@Valid @RequestBody Utilisateur utilisateur,BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);	
		}
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPass()));
		utilisateur.setRole(Role.ROLE_USER);
		return utilisateurRepo.save(utilisateur);
	}
}
