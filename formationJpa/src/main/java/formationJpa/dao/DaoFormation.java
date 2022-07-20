package formationJpa.dao;

import java.util.List;

import formationJpa.entities.Formateur;
import formationJpa.entities.Formation;

public interface DaoFormation extends DaoGeneric<Formation, Long> {
	public List<Formation> demoJpql();

	public void setReferentToNull(Formateur formateur);

	public void deleteByReferent(Formateur formateur);
	
}
