package demoSpring;

public class Guitariste implements Musicien {
	private Instrument instrument;

	@Override
	public String perfom() {
		return "le guitariste joue," + instrument.jouer();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
