package formation.sopra.formationSpringBoot.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSpringBoot.entities.JsonViews;
import formation.sopra.formationSpringBoot.entities.Utilisateur;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

	private final static Logger LOGGER=LoggerFactory.getLogger(AuthRestController.class);
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public Utilisateur auth(@AuthenticationPrincipal Utilisateur utilisateur) {
		LOGGER.info(utilisateur.getLogin());
		return utilisateur;
	}
}
