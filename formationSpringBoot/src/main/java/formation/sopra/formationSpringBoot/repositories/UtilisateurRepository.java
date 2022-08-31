package formation.sopra.formationSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.formationSpringBoot.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Optional<Utilisateur> findByLogin(String login);
}
