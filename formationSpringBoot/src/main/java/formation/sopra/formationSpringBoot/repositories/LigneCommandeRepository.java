package formation.sopra.formationSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.formationSpringBoot.entities.LigneCommande;
import formation.sopra.formationSpringBoot.entities.LigneCommandeKey;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandeKey> {

}
