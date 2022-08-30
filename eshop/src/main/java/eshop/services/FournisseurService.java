package eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.entities.Fournisseur;
import eshop.exceptions.FournisseurException;
import eshop.repositories.FournisseurRepository;
import eshop.repositories.ProduitRepository;

@Service
public class FournisseurService {
	@Autowired
	private FournisseurRepository fournisseurRepo;
	@Autowired
	private ProduitRepository produitRepo;

	public Fournisseur create(Fournisseur fournisseur) {
		return fournisseurRepo.save(fournisseur);
	}

	public Fournisseur getById(Long id) {
		return fournisseurRepo.findById(id).orElseThrow(FournisseurException::new);
	}

	public Fournisseur getByIdWithProduits(Long id) {
		return fournisseurRepo.findByIdWithProduits(id).orElseThrow(FournisseurException::new);
	}

	public Fournisseur update(Fournisseur fournisseur) {
		Fournisseur fournisseurEnBase = getById(fournisseur.getId());
		fournisseurEnBase.setNom(fournisseur.getNom());
		fournisseurEnBase.setAdresse(fournisseur.getAdresse());
		fournisseurEnBase.setContact(fournisseur.getContact());
		return fournisseurRepo.save(fournisseurEnBase);
	}

	public List<Fournisseur> getAll() {
		return fournisseurRepo.findAll();
	}

	public void delete(Fournisseur fournisseur) {
		produitRepo.setFournisseurToNullByFournisseur(fournisseur);
		fournisseurRepo.delete(fournisseur);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

}
