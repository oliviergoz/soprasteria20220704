package eshop.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.entities.Fournisseur;
import eshop.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Transactional
	@Modifying
	@Query("update Produit p set p.fournisseur=null where p.fournisseur=:fournisseur")
	void setFournisseurToNullByFournisseur(@Param("fournisseur") Fournisseur fournisseur);
}
