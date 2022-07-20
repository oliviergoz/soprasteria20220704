package demoSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demoSpring.config.Config;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		Musicien musicien = ctx.getBean("pianiste", Musicien.class);
		System.out.println(musicien.perfom());
		ctx.close();

	}
}
