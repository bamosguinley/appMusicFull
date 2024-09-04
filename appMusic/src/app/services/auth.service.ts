import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8081/auth'; // URL de votre backend

  constructor(private http: HttpClient) {}

  register(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/register`, null, {
      params: { username, password },
    });
  }
  
  login(username: string, password: string): Observable<any> {
    // Envoyer les données comme JSON dans le corps de la requête
    return this.http.post(
      `${this.apiUrl}/login`,
      { username, password }, // Corps de la requête
      { withCredentials: true } // Options de la requête
    );
  }

  logout(): Observable<any> {
    return this.http.post(
      `${this.apiUrl}/logout`,
      {},
      { withCredentials: true }
    );
  }
}
