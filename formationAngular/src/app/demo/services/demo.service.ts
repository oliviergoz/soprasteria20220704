import { Injectable } from '@angular/core';
import { Produit } from 'src/app/formation/class/produit';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  private _produit: Produit = new Produit();

  constructor() {
    console.log('constructeur');
  }

  public sayHello(): string {
    return 'hello du service';
  }

  public getNewProduit(nom?: string, prix?: number): Produit {
    this._produit = new Produit(nom, prix);
    return this._produit;
  }
}
