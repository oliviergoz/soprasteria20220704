package formation.sopra.authExercice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.authExercice.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	Optional<Compte> findByLogin(String login);
}
