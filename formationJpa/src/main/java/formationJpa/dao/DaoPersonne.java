package formationJpa.dao;

import java.util.List;

import formationJpa.entities.Formateur;
import formationJpa.entities.Personne;
import formationJpa.entities.Stagiaire;

public interface DaoPersonne extends DaoGeneric<Personne, Long> {
	List<Formateur> findAllFormateur();

	public Formateur findFormateurByKey(Long key);

	public Stagiaire findStagiaireByKey(Long key);
}
