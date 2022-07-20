package demoSpring;

public class Pianiste implements Musicien {
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
