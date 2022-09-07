import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../model/produit';
import { ConvertService } from './convert.service';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  static URL: string = 'http://localhost:8080/eshop/api/produit';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertService
  ) {}

  public getAll(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(ProduitService.URL);
  }

  public getById(id: number): Observable<Produit> {
    return this.httpClient.get<Produit>(`${ProduitService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ProduitService.URL}/${id}`);
  }

  public update(produit: Produit): Observable<Produit> {
    return this.httpClient.put<Produit>(
      `${ProduitService.URL}/${produit.id}`,
      this.convert.produitToJson(produit)
    );
  }

  public create(produit: Produit): Observable<Produit> {
    return this.httpClient.post<Produit>(
      ProduitService.URL,
      this.convert.produitToJson(produit)
    );
  }
}
