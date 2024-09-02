import { Injectable } from '@angular/core';
import { Album } from '../interfaces/album';
import { ALBUM_LISTS } from '../mock-albums';
import { List } from '../interfaces/list';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AlbumService {
  private apiUrl = 'localhost:8001/api/albums';
  albumsSongs: List[] = ALBUM_LISTS;
  constructor(private http: HttpClient) { }
  
  getAlbums(): Observable<Album[]> {
    return this.http.get<Album[]>(this.apiUrl);
  }
  getSongs() {
    return this.albumsSongs;
  }
}
