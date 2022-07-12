package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.entities.Personne;
import formationJpa.util.Context;

public class ConfigJpaTest {
	public static void main(String[] args) {

		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		Personne olivier = new Personne();
		olivier.setPrenom("olivier");
		System.out.println(olivier.getId());
		daoPersonne.insert(olivier);
		System.out.println(olivier.getId());

		Context.destroy();
	}
}
