package formation.sopra.formationSpringBoot.services;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.entities.Commande;
import formation.sopra.formationSpringBoot.entities.LigneCommande;
import formation.sopra.formationSpringBoot.entities.LigneCommandeKey;
import formation.sopra.formationSpringBoot.entities.Produit;
import formation.sopra.formationSpringBoot.exceptions.CommandeException;
import formation.sopra.formationSpringBoot.repositories.CommandeRepository;
import formation.sopra.formationSpringBoot.repositories.LigneCommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepo;
	@Autowired
	private LigneCommandeRepository lCRepo;
	@Autowired
	private ClientService clientService;

	public Commande create(Commande commande) {
		if (commande.getDate() == null) {
			commande.setDate(LocalDate.now());
		}
		commandeRepo.save(commande);
		commande.getLignes().forEach(ligne -> {
			ligne.getId().setCommande(commande);
		});
		lCRepo.saveAll(commande.getLignes());
		return commande;
	}

	public Commande create(Map<Produit, Integer> panier, Client client) {
		Client clientBase = clientService.getById(client.getId());
		Commande commande = new Commande(clientBase);
		commandeRepo.save(commande);
		panier.forEach((k, v) -> {
			lCRepo.save(new LigneCommande(new LigneCommandeKey(commande, k), v));
		});
		return commande;
	}

	public Commande getById(Long id) {
		return commandeRepo.findByIdWithLignes(id).orElseThrow(CommandeException::new);
	}
}
