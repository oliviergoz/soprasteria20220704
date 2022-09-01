package formation.sopra.formationSpringBoot.myTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import formation.sopra.formationSpringBoot.entities.Utilisateur;
import formation.sopra.formationSpringBoot.repositories.UtilisateurRepository;

@SpringBootTest
class UtilisateurTest {

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	@Transactional
	@Commit
	@Disabled
	void encodePassword() {
		Utilisateur utilisateur=utilisateurRepo.findById(999999L).get();
		utilisateur.setPassword(passwordEncoder.encode("olivier"));
		utilisateurRepo.save(utilisateur);
	}

}
