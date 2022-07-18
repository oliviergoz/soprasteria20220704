package formationJpa.dao;

import java.util.List;

import formationJpa.entities.Formateur;
import formationJpa.entities.Personne;
import formationJpa.entities.Stagiaire;

public interface DaoPersonne extends DaoGeneric<Personne, Long> {
	List<Formateur> findAllFormateur();

	public Formateur findFormateurByKey(Long key);

	public Stagiaire findStagiaireByKey(Long key);

	Formateur findFormateurByIdWithFormations(Long id);

	public Formateur findFormateurByIdWithFormationsAndWithCompetences(Long id);

	public Formateur findFormateurByIdWithCompetences(Long id);

	public List<Formateur> findAllFormateurWithFormations();
}
