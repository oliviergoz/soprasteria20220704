import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fournisseur } from '../model/fournisseur';

@Injectable({
  providedIn: 'root',
})
export class FournisseurService {
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Fournisseur[]> {
    return this.httpClient.get<Fournisseur[]>(
      'http://localhost:8080/eshop/api/fournisseur'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      'http://localhost:8080/eshop/api/fournisseur/' + id
    );
  }

  public getById(id: number): Observable<Fournisseur> {
    return this.httpClient.get<Fournisseur>(
      'http://localhost:8080/eshop/api/fournisseur/' + id
    );
  }

  public update(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.put<Fournisseur>(
      'http://localhost:8080/eshop/api/fournisseur/' + fournisseur.id,
      this.fournisseurToJson(fournisseur)
    );
  }

  public create(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.post<Fournisseur>(
      'http://localhost:8080/eshop/api/fournisseur',
      this.fournisseurToJson(fournisseur)
    );
  }

  private fournisseurToJson(fournisseur: Fournisseur): any {
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
}
