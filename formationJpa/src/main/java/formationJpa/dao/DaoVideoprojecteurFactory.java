package formationJpa.dao;

public class DaoVideoprojecteurFactory {
	private static DaoVideoprojecteur daoVideoprojecteur = null;

	public static DaoVideoprojecteur getInstance() {
		if (daoVideoprojecteur == null) {
			daoVideoprojecteur = new DaoVideoprojecteurJpaImpl();
		}
		return daoVideoprojecteur;
	}
}
