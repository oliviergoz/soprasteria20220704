import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fournisseur } from '../model/fournisseur';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root',
})
export class FournisseurService {
  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) {}

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
      this.convert.fournisseurToJson(fournisseur)
    );
  }

  public create(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.post<Fournisseur>(
      'http://localhost:8080/eshop/api/fournisseur',
      this.convert.fournisseurToJson(fournisseur)
    );
  }
}
