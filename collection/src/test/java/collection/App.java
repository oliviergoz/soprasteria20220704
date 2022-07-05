package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();

		collection.add("hello");
		collection.add("world");
		collection.add("aaaa");
		System.out.println("--------------");
		Iterator<String> iterator = collection.iterator();
		String chaineLu = null;
		while (iterator.hasNext()) {
			chaineLu = iterator.next();
			System.out.println(chaineLu);
		}
		collection.remove("aaaa");
		System.out.println("--------------");
		for (String s : collection) {
			System.out.println(s);
		}
		System.out.println("--------------");
		List<Personne> list = new LinkedList<Personne>();
		Personne olivier = new Personne(1L, "olivier", "gozlan");
		list.add(olivier);
		list.add(olivier);
		list.add(olivier);
		list.add(new Personne(2L, "nisar", "benina"));
		for (Personne p : list) {
			System.out.println(p.getId() + " " + p.getPrenom());
		}
		System.out.println(list.get(0).getPrenom());
		System.out.println("--------------");
		list.remove(olivier);
		for (Personne p : list) {
			System.out.println(p.getId() + " " + p.getPrenom());
		}
		System.out.println("--------------");
		list.remove(new Personne(2L, null, null));
		for (Personne p : list) {
			System.out.println(p.getId() + " " + p.getPrenom());
		}
		System.out.println("--------------");

		Set<Personne> set = new HashSet<Personne>();

		set.add(olivier);
		set.add(olivier);
		set.add(olivier);
		set.add(new Personne(1L, null, null));
		set.add(new Personne(2L,"klkl","lklklk"));
		set.add(new Personne(1L, null, null));
		System.out.println(set);
	}
}
