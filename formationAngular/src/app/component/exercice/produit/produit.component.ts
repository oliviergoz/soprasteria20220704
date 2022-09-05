import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/formation/class/produit';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  recuperationProduit(produitRecupere: any) {
    this.produit = produitRecupere;
  }
}
