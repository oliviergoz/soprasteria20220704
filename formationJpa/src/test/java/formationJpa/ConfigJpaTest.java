package formationJpa;

import java.time.LocalDate;

import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.dao.DaoModule;
import formationJpa.dao.DaoModuleFactory;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.entities.Adresse;
import formationJpa.entities.Civilte;
import formationJpa.entities.Formateur;
import formationJpa.entities.Formation;
import formationJpa.util.Context;

public class ConfigJpaTest {
	public static void main(String[] args) {

		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		DaoFormation daoFormation = DaoFormationFactory.getInstance();
		DaoModule daoModule = DaoModuleFactory.getInstance();

		Formation formation = new Formation("java", LocalDate.of(2022, 7, 12));
		daoFormation.insert(formation);
//
		Formateur olivier = new Formateur();
		olivier.setPrenom("olivier");
		daoPersonne.insert(olivier);
		olivier.setCivilite(Civilte.MLLE);
		olivier = (Formateur) daoPersonne.update(olivier);
		// olivier=daoPersonne.findFormateurByKey(olivier.getId());
		olivier.setAdresse(new Adresse("1", "rue", "3333", "aaaa"));
		olivier = (Formateur) daoPersonne.update(olivier);

		formation.setReferent(olivier);
		daoFormation.update(formation);

		formation = new Formation();
		formation.setReferent(olivier);
		daoFormation.insert(formation);
		formation = new Formation();
		formation.setReferent(olivier);
		daoFormation.insert(formation);

		Formateur formateur = daoPersonne.findFormateurByIdWithFormations(100L);
		System.out.println(formateur.getFormations());

		formateur = new Formateur();
		formateur.setPrenom("toto");
		daoPersonne.insert(formateur);
		//daoFormation.deleteByReferent(olivier);
		daoFormation.setReferentToNull(olivier);
		daoPersonne.delete(olivier);

		// // traitements.....
//		// Formateur referent = new Formateur();
//		referent.setId(100L);
//
//		Module java = new Module("java");
//		Module jpa = new Module("jpa");
//		daoModule.insert(jpa);
//		daoModule.insert(java);
//
//		Set<Module> modules = new HashSet<Module>();
//		modules.add(jpa);
//		modules.add(java);
//		olivier.setModules(modules);
//		daoPersonne.update(olivier);
//		modules.remove(jpa);
//		daoPersonne.update(olivier);
//
//		ModuleFormation m1 = new ModuleFormation(new ModuleFormationKey(formation, jpa), olivier,
//				LocalDate.of(2022, 7, 12), LocalDate.of(2022, 7, 19));
//		DaoModuleFormation daoModuleFormation = DaoModuleFormationFactory.getInstance();
//		daoModuleFormation.insert(m1);
//		daoModuleFormation.insert(new ModuleFormation(new ModuleFormationKey(formation, java), olivier,
//				LocalDate.of(2022, 7, 1), LocalDate.of(2022, 7, 5)));
		Context.destroy();
	}
}
