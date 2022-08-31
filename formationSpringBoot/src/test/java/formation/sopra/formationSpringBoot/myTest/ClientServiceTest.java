package formation.sopra.formationSpringBoot.myTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.exceptions.ClientException;
import formation.sopra.formationSpringBoot.services.ClientService;

@SpringBootTest
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
