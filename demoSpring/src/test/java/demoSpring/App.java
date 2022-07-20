package demoSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		Musicien musicien = ctx.getBean("guitariste", Musicien.class);
		System.out.println(musicien.perfom());
		ctx.close();

	}
}
