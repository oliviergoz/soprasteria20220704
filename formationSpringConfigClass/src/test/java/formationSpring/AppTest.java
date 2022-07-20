package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationSpring.beans.IPersonne;
import formationSpring.config.Config;

public class AppTest {
	public static void main(String[] args) {
		// chargement de spring
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
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
