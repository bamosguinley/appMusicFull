import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MusicService {
  private apiUrl = 'http://localhost:8081/api/musiques';

  constructor(private http: HttpClient) {}

  // Méthode pour ajouter une musique à un album
  addMusicToAlbum(albumId: string, musicData: { title: string; paroles: string }): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}`, musicData);
  }
}
