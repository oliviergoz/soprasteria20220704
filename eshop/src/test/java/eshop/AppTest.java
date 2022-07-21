package eshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.AppConfig;
import eshop.repositories.ClientRepository;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ClientRepository clientRepo = ctx.getBean(ClientRepository.class);
		clientRepo.findAll();
		ctx.close();
		
	}
}
