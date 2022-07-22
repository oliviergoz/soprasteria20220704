package eshop;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import eshop.config.AppConfig;
import eshop.entities.Client;
import eshop.exceptions.ClientException;
import eshop.services.ClientService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;

	@Test
	public void injectionClientServiceTest() {
		assertNotNull(clientService);
	}

	@Test
	//@Commit
	public void creationClientTest() {
		Client client = new Client("olivierrrrr", "gozlan", null, null);
		clientService.create(client);
		assertNotNull(clientService.getById(client.getId()));
	}

	@Test
	public void getClient() {
		assertThrows(ClientException.class, () -> {
			clientService.getById(100000L);
		});
	}

	@Disabled
	@Test
	public void crashTest() {
		fail("un test qui echoue");
	}
}
