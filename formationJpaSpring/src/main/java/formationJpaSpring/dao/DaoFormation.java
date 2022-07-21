package formationJpaSpring.dao;

import formationJpaSpring.entities.Formateur;
import formationJpaSpring.entities.Formation;

public interface DaoFormation extends DaoGeneric<Formation, Long> {

	public void setReferentToNull(Formateur formateur);

	public void deleteByReferent(Formateur formateur);
}
