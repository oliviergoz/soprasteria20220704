package demoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements Musicien {
	@Autowired
	@Qualifier("guitare")
	private Instrument instrument;

	@Override
	public String perform() {
		System.out.println("le guitariste joue");
		//return "le guitariste joue," + instrument.jouer();
		throw new IllegalArgumentException();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
