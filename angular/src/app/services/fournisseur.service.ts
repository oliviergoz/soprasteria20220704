import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FournisseurService {
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Object[]> {
    return this.httpClient.get<Object[]>(
      'http://localhost:8080/eshop/api/fournisseur'
    );
  }
}
