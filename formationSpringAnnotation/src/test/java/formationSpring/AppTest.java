package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.beans.IPersonne;
import formationSpring.beans.Personne;

public class AppTest {
	public static void main(String[] args) {
		// chargement de spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
//		Personne personne = ctx.getBean(Personne.class);
//		System.out.println(personne);
		IPersonne personne = (IPersonne) ctx.getBean("olivier");
		System.out.println(personne);
		System.out.println(personne.getPrenom());
		System.out.println(personne.getAdresse().getAdresse());
		// fermeture du context spring
		ctx.close();
	}
}
