package eshop.dao;

public class DaoLigneCommandeFactory {
	private static DaoLigneCommande daoLigneCommande = null;

	public static DaoLigneCommande getInstance() {
		if (daoLigneCommande == null) {
			daoLigneCommande = new DaoLigneCommandeJpaImpl();
		}
		return daoLigneCommande;
	}

	private DaoLigneCommandeFactory() {

	}
}
