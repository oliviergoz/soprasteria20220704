package formationJpa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.entities.Adresse;
import formationJpa.entities.Civilte;
import formationJpa.entities.Formateur;
import formationJpa.entities.Formation;
import formationJpa.entities.Personne;
import formationJpa.entities.Stagiaire;
import formationJpa.util.Context;

public class ConfigJpaTest {
	public static void main(String[] args) {

		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		DaoFormation daoFormation = DaoFormationFactory.getInstance();
		Formation formation = new Formation("java", LocalDate.of(2022, 7, 12));
		daoFormation.insert(formation);

		Formateur olivier = new Formateur();
		olivier.setPrenom("olivier");
		olivier.setCivilite(Civilte.MLLE);
		olivier.setAdresse(new Adresse("1", "rue", "3333", "aaaa"));
		daoPersonne.insert(olivier);

		Formateur referent = new Formateur();
		referent.setId(100L);
		formation.setReferent(referent);
		System.out.println("--------------");
		daoFormation.update(formation);

		formation = daoFormation.findByKey(100L);
		System.out.println(formation.getReferent());
		Context.destroy();
	}
}
