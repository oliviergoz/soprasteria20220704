package eshop.dao;

public class DaoProduitFactory {
	private static DaoProduit daoProduit = null;

	public static DaoProduit getInstance() {
		if (daoProduit == null) {
			daoProduit = new DaoProduitJpaImpl();
		}
		return daoProduit;
	}

	private DaoProduitFactory() {

	}
}
