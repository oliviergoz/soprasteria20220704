package formationJpa.dao;

public class DaoSalleFactory {
	private static DaoSalle daoSalle = null;

	public static DaoSalle getInstance() {
		if (daoSalle == null) {
			daoSalle = new DaoSalleJpaImpl();
		}
		return daoSalle;
	}
}
