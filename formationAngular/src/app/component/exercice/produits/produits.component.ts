import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/demo/services/produit.service';
import { Produit } from 'src/app/formation/class/produit';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css'],
})
export class ProduitsComponent implements OnInit {
  produits: Produit[] = [];

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.produits = this.produitService.produits;
  }

  getProduit(produit: Produit) {
    this.produits.push(produit);
  }
}
