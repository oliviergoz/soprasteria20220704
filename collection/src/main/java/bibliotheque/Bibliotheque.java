package bibliotheque;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bibliotheque.exception.DisqueDejaPresentException;

public class Bibliotheque implements Serializable{
	private Set<Disque> disques = new LinkedHashSet<Disque>();

	public Bibliotheque() {

	}

	public void ajouterDisque(Disque disque) throws DisqueDejaPresentException {
		if (!disques.add(disque)) {
			throw new DisqueDejaPresentException("disque deja dans la bibliotheque");
		}
	}

	public boolean retirerDisque(String codeBarre) {
		return disques.remove(new Disque(null, codeBarre));
	}

	public int getNbDisques() {
		return disques.size();
	}

	public Disque getDisque(String codeBarre) {
//		for (Disque disque : disques) {
//			if (disque.getCodeBarre().equals(codeBarre)) {
//				return disque;
//			}
//		}
//		return null;

		return disques.stream().filter(disque -> disque.getCodeBarre().equals(codeBarre)).findFirst().orElse(null);
	}

	public List<Disque> rechercherDisques(String recherche) {
//		List<Disque> list = new ArrayList<Disque>();
//		for (Disque disque : disques) {
//			if (disque.getNom().toLowerCase().contains(recherche.toLowerCase())) {
//				list.add(disque);
//			}
//		}
//		return list;

		return disques.stream().filter(disque -> disque.getNom().toLowerCase().contains(recherche.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<Chanson> rechercherChansons(String recherche) {
//		List<Chanson> list = new ArrayList<Chanson>();
//		for (Disque disque : disques) {
//			for (Chanson chanson : disque.getChansons()) {
//				if (chanson.getNom().toLowerCase().contains(recherche.toLowerCase())) {
//					list.add(chanson);
//				}
//			}
//		}
//		return list;

		return disques.stream().flatMap(disque -> disque.getChansons().stream())
				.filter(chanson -> chanson.getNom().toLowerCase().contains(recherche.toLowerCase()))
				.collect(Collectors.toList());
	}

	public static Bibliotheque load(String nom) {
		Bibliotheque biblio = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nom));
			biblio = (Bibliotheque) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return biblio;
	}

	public void save(String nom) {
		// sauvegarde la bibliotheque (this) dans un fichier
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/" + nom));
			oos.writeObject(this);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
