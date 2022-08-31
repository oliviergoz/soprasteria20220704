package formation.sopra.formationSpringBoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import formation.sopra.formationSpringBoot.entities.Adresse;
import formation.sopra.formationSpringBoot.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByPrenom(String prenom);

	List<Client> findByPrenomContaining(String prenom);

	List<Client> findByPrenomOrNom(String prenom, String nom);

	List<Client> findByPrenomContainingOrNomContaining(String prenom, String nom);

	@Query("select c from Client c left join fetch c.commandes where c.id=:id")
	Optional<Client> findByKeyWithCommandes(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query("delete from Client c where c.adresse=:adresse")
	void deleteByAdresse(@Param("adresse") Adresse adresse);
}
