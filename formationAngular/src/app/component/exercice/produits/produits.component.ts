import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/formation/class/produit';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css'],
})
export class ProduitsComponent implements OnInit {
  produits: Produit[] = [
    new Produit('velo', 100),
    new Produit('avion', -9999999),
  ];

  constructor() {}

  ngOnInit(): void {}

  getProduit(produit: Produit) {
    this.produits.push(produit);
  }
}
