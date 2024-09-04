import { Injectable } from '@angular/core';
import { List } from '../interfaces/list';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Album } from '../interfaces/album';

@Injectable({
  providedIn: 'root',
})
export class AlbumService {

  private apiUrl = 'http://localhost:8081/api/albums';
  constructor(private http: HttpClient) {}
  // Méthode pour obtenir les albums depuis l'API
  getAlbums(): Observable<Album[]> {
    return this.http.get<Album[]>(this.apiUrl);
  }

  // Méthode pour obtenir les chansons des albums
  getSongs(): Observable<List[]> {
    // Remplacez cette URL par celle qui fournit les chansons des albums, si disponible
    return this.http.get<List[]>('http://localhost:8081/api/musiques');
  }
}
