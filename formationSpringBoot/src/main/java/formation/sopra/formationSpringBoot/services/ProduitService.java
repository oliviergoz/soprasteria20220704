package formation.sopra.formationSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.entities.Fournisseur;
import formation.sopra.formationSpringBoot.entities.Produit;
import formation.sopra.formationSpringBoot.exceptions.ProduitException;
import formation.sopra.formationSpringBoot.repositories.ProduitRepository;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private FournisseurService fournisseurService;

	public Produit create(Produit produit) {
		Fournisseur fournisseur = produit.getFournisseur();
		if (fournisseur != null) {
			fournisseur = fournisseurService.getById(fournisseur.getId());
			produit.setFournisseur(fournisseur);
		}
		return produitRepo.save(produit);
	}

	public Produit getById(Long id) {
		return produitRepo.findById(id).orElseThrow(ProduitException::new);
	}

	public Produit update(Produit produit) {
		Produit produitEnBase = getById(produit.getId());
		produitEnBase.setLibelle(produit.getLibelle());
		produitEnBase.setPrixUnitaire(produit.getPrixUnitaire());
		produitEnBase.setDescription(produit.getDescription());
		Fournisseur fournisseur = produit.getFournisseur();
		if (fournisseur != null) {
			fournisseur = fournisseurService.getById(fournisseur.getId());
			produitEnBase.setFournisseur(fournisseur);
		}
		return produitRepo.save(produitEnBase);
	}

	public List<Produit> getAll() {
		return produitRepo.findAll();
	}

	public void delete(Produit produit) {
		produitRepo.delete(produit);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

}
