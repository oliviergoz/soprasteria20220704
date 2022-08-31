package formation.sopra.formationSpringBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "not found")
public class CommandeException extends RuntimeException {
	public CommandeException() {

	}

	public CommandeException(String message) {
		super(message);
	}

}
