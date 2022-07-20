package demoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pianiste implements Musicien {
	@Autowired
	@Qualifier("piano")
	private Instrument instrument;

	@Override
	public String perfom() {
		return "le pianiste joue, " + instrument.jouer();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
