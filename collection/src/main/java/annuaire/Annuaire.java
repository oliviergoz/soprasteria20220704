package annuaire;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import collection.Personne;

public class Annuaire {
	private Map<Personne, Set<Coordonnee>> map = new HashMap<Personne, Set<Coordonnee>>();

	public void ajouterEntree(Personne personne, Coordonnee coordonnee) {
		if (map.containsKey(personne)) {
			map.get(personne).add(coordonnee);
		} else {
			Set<Coordonnee> coordonnees = new HashSet<Coordonnee>();
			coordonnees.add(coordonnee);
			map.put(personne, coordonnees);
		}
	}

	public void suppression(Personne personne) {
		map.remove(personne);
	}

	public void suppression(Coordonnee coordonnee) {
		map.forEach((k, v) -> {
			if (v.contains(coordonnee)) {
				v.remove(coordonnee);
			}
		});
	}

	public Set<Coordonnee> recherche(Personne personne) {
		return map.get(personne);
	}

	public Map<Personne, Set<Coordonnee>> recherche(String telephone) {
		Map<Personne, Set<Coordonnee>> mapARenvoyer = new HashMap<Personne, Set<Coordonnee>>();
		for (Personne p : map.keySet()) {
			for (Coordonnee c : map.get(p)) {
				if (c.getTelephone().equals(telephone)) {
					mapARenvoyer.put(p, map.get(p));
					break;
				}
			}
		}
		return mapARenvoyer;
	}

	public Map<Personne, Set<Coordonnee>> recherche(Adresse adresse) {
		return map.entrySet().stream().filter(map -> map.getValue().contains(adresse))
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
	}

}
