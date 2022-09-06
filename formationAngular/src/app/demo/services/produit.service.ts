import { Injectable } from '@angular/core';
import { Produit } from 'src/app/formation/class/produit';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  _produits: Produit[] = [new Produit('velo', 100), new Produit('pomme', 1)];

  constructor() {}

  public get produits(): Produit[] {
    return this._produits;
  }

  public get(index: number): Produit {
    return this.produits[index];
  }
}
