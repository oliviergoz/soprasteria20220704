package formationJpa.dao;

import java.util.List;

import formationJpa.entities.Formateur;
import formationJpa.entities.Personne;

public interface DaoPersonne extends DaoGeneric<Personne, Long> {
	List<Formateur> findAllFormateur();
}
