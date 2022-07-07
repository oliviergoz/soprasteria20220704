package formationJdbc.dao;

public class DaoEmployeeFactory {

	private static DaoEmployee singleton = null;

	public static DaoEmployee getInstance() {
		if (singleton == null) {
			singleton = new DaoEmployeeJdbcImpl();
		}
		return singleton;
	}
}
