package eshop.dao;

public class DaoCommandeFactory {
	private static DaoCommande daoCommande = null;

	public static DaoCommande getInstance() {
		if (daoCommande == null) {
			daoCommande = new DaoCommandeJpaImpl();
		}
		return daoCommande;
	}

	private DaoCommandeFactory() {

	}
}
