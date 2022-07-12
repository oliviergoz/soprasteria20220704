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
import formationJpa.entities.Formation;
import formationJpa.entities.Personne;
import formationJpa.util.Context;

public class ConfigJpaTest {
	public static void main(String[] args) {

		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		DaoFormation daoFormation=DaoFormationFactory.getInstance();
		daoFormation.insert(new Formation("java", LocalDate.of(2022,7,12)));
		Formation f=daoFormation.findByKey(100L);
		System.out.println(f.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		Context.destroy();
	}
}
