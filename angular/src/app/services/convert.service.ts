import { Injectable } from '@angular/core';
import { Fournisseur } from '../model/fournisseur';
import { Produit } from '../model/produit';

@Injectable({
  providedIn: 'root',
})
export class ConvertService {
  constructor() {}
  public fournisseurToJson(fournisseur: Fournisseur): any {
    let obj = {
      id: fournisseur.id,
      nom: fournisseur.nom,
    };
    if (fournisseur.contact) {
      Object.assign(obj, {
        contact: {
          prenom: fournisseur.contact.prenom,
          nom: fournisseur.contact.nom,
          mail: fournisseur.contact.mail,
        },
      });
    }
    if (fournisseur.adresse) {
      Object.assign(obj, {
        adresse: {
          numero: fournisseur.adresse.numero,
          rue: fournisseur.adresse.rue,
          codePostal: fournisseur.adresse.codePostal,
          ville: fournisseur.adresse.ville,
        },
      });
    }
    return obj;
  }

  public produitToJson(produit: Produit): any {
    let obj = {
      id: produit.id,
      libelle: produit.libelle,
      description: produit.description,
      prixUnitaire: produit.prixUnitaire,
    };
    if (produit.fournisseur) {
      Object.assign(obj, {
        fournisseur: this.fournisseurToJson(produit.fournisseur),
      });
    }
    return obj;
  }
}
