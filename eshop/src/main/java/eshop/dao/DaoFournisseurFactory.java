package eshop.dao;

public class DaoFournisseurFactory {
	private static DaoFournisseur daoFournisseur = null;

	public static DaoFournisseur getInstance() {
		if (daoFournisseur == null) {
			daoFournisseur = new DaoFournisseurJpaImpl();
		}
		return daoFournisseur;
	}

	private DaoFournisseurFactory() {

	}
}
