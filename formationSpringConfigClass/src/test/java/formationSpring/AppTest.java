package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationSpring.beans.IPersonne;
import formationSpring.beans.Personne;
import formationSpring.beans.Presentation;
import formationSpring.config.Config;

public class AppTest {
	public static void main(String[] args) {
		// chargement de spring
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		Presentation olivier = (Presentation) ctx.getBean("olivier");
		System.out.println(olivier.sePresenter());
		ctx.close();
	}
}
