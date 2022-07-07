package formationJdbc.dao;

public class DaoDepartementFactory {
	private static DaoDepartement daoDepartement = null;

	public static DaoDepartement getInstance() {
		if (daoDepartement == null) {
			daoDepartement = new DaoDepartementJdbcImpl();
		}
		return daoDepartement;
	}

	private DaoDepartementFactory() {

	}
}
