package eshop;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.AppConfig;
import eshop.services.ClientService;

public class SpringContextTest {

	static private AnnotationConfigApplicationContext ctx;
	private ClientService clientService;

	@BeforeAll
	public static void initSpringContext() {
		System.out.println("beforeAll");
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterAll
	public static void closeSpringContext() {
		System.out.println("afterall");
		ctx.close();
	}

	@BeforeEach
	public void initClientService() {
		System.out.println("beforeEach");
		clientService = ctx.getBean(ClientService.class);
	}

	@Test
	public void contextTest() {
		assertNotNull(ctx);

	}

	@Test
	public void autreTestAvecSpring() {
		assertNotNull(clientService);
	}
}
