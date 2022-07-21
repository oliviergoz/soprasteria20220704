package formationJpaSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationJpaSpring.config.AppConfig;
import formationJpaSpring.dao.DaoFormation;

public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		DaoFormation daoFormation = ctx.getBean(DaoFormation.class);
		
		ctx.close();
	}

}
