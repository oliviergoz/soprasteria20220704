package formation.sopra.formationSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.repositories.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return utilisateurRepo.findByLogin(username).orElseThrow(()->{throw new UsernameNotFoundException("utilisateur inconnu");});
	}

}
