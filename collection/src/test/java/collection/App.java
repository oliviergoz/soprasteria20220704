package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import bibliotheque.Bibliotheque;
import bibliotheque.Chanson;
import bibliotheque.Disque;
import bibliotheque.exception.DisqueDejaPresentException;

public class App {
	public static void main(String[] args) {
		// testBibliotheque();
		// testlambda();
		// demoMap();
		testLoad();
	}

	private static void testLoad() {
		Bibliotheque biblio = Bibliotheque.load("src/main/resources/biblio");
		System.out.println(biblio.getNbDisques());

		System.out.println(biblio.rechercherDisques("best").size());

		System.out.println(biblio.rechercherDisques("bob").size());

		System.out.println(biblio.rechercherChansons("th").size());

	}

	private static void demoMap() {
		Map<Personne, Disque> map = new HashMap<Personne, Disque>();

		map.put(new Personne("aaa", "bbb"), new Disque("disqueAAA", "disqueAAA"));
		map.put(new Personne("bbb", "cccc"), new Disque("disqueBBB", "disqueBBB"));

		System.out.println(map.get(new Personne(null, null)));
		System.out.println("--------------");
		for (Personne p : map.keySet()) {
			System.out.println(map.get(p));
		}
		System.out.println("--------------");
		for (Disque disque : map.values()) {
			System.out.println(disque);
		}
		System.out.println("--------------");
		map.forEach((k, v) -> {
			System.out.println(k + " " + v);
		});
	}

	private static void testlambda() {
//		String[] tab = { "toto", "maman", "papa", "avion" };
//		Arrays.sort(tab);
//		for (String s : tab) {
//			System.out.println(s);
//		}
//
//		Arrays.sort(tab, (s1, s2) -> {
//			return -((String) s1).compareTo((String) s2);
//		});

//		for (String s : tab) {
//			System.out.println(s);
//		}

//		List<String> list = Arrays.asList("toto", "maman", "papa", "avion");
//		list.forEach(s -> {
//			System.out.println(s);
//		});

//		List<Chanson> list = Arrays.asList(new Chanson("no women no cry", 400), new Chanson("i shoot the sherif", 500),
//				new Chanson("hightway to hell", 666));
		Set<Chanson> chansonDeBobMarley = new HashSet<Chanson>();
		chansonDeBobMarley.add(new Chanson("no women no cry", 400));
		chansonDeBobMarley.add(new Chanson("i shoot the sherif", 500));

		Disque disque1 = new Disque("best of bob marley", "1234AZER", chansonDeBobMarley);
		List<Disque> list = Arrays.asList(disque1, new Disque("best of acdc", "666ACDC",
				new Chanson("hightway to hell", 666), new Chanson("thunder", 400)));

		List<Chanson> allChansons = list.stream().flatMap(disque -> disque.getChansons().stream())
				.collect(Collectors.toList());
		System.out.println(allChansons);

		System.out.println(list.stream().map(disque -> disque.getChansons()).collect(Collectors.toList()));

	}

	private static void testBibliotheque() {
		Bibliotheque biblio = new Bibliotheque();

		Set<Chanson> chansonDeBobMarley = new HashSet<Chanson>();
		chansonDeBobMarley.add(new Chanson("no women no cry", 400));
		chansonDeBobMarley.add(new Chanson("i shoot the sherif", 500));

		Disque disque1 = new Disque("best of bob marley", "1234AZER", chansonDeBobMarley);

//		Disque disque1 = new Disque("best of bob marley", "1234AZER");
//		disque1.addChanson(new Chanson("no women no cry", 400));
//		disque1.addChanson(new Chanson("i shoot the sherif", 500));
		try {
			biblio.ajouterDisque(disque1);
		} catch (DisqueDejaPresentException ex) {
			ex.printStackTrace();
		}
		try {
			biblio.ajouterDisque(disque1);
		} catch (DisqueDejaPresentException ex) {
			ex.printStackTrace();
		}

		Disque acdc = new Disque("best of acdc", "666ACDC", new Chanson("hightway to hell", 666),
				new Chanson("thunder", 400));
//		acdc.addChanson(new Chanson("hightway to hell", 666));
//		acdc.addChanson(new Chanson("thunder", 400));
		try {
			biblio.ajouterDisque(acdc);
		} catch (DisqueDejaPresentException ex) {
			ex.printStackTrace();
		}

		System.out.println(biblio.getNbDisques());

		System.out.println(biblio.rechercherDisques("best").size());

		System.out.println(biblio.rechercherDisques("bob").size());

		System.out.println(biblio.rechercherChansons("th").size());

		biblio.save("biblio");
	}
}
