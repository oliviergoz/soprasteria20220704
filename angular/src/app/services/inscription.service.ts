import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class InscriptionService {
  private static URL: string =
    'http://localhost:8080/eshop/api/auth/inscription';

  constructor(private httpClient: HttpClient) {}

  public checkUtilisateurExist(login: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      'http://localhost:8080/eshop/api/auth/check/' + login
    );
  }

  public inscription(utilisateur: any): Observable<any> {
    return this.httpClient.post<any>(InscriptionService.URL, utilisateur);
  }
}
