import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FavorisService {
  private Favoris: any[] = [];
  constructor() { }
 // Ajoute un album aux Favoris
 addFavorite(album: any) {
  this.Favoris.push(album);
}

  // Récupère tous les Favoris
  getFavorites(): any[] {
    return this.Favoris;
  }

  // Supprime un élément des Favoris
  removeFavorite(album: any) {
    this.Favoris = this.Favoris.filter(fav => fav !==album.id);
  }
}
