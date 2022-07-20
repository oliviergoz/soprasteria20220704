package demoSpring;

import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument {

	@Override
	public String jouer() {
		return "piano";
	}

}
