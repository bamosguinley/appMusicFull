import { Component } from '@angular/core';
import { Album } from '../interfaces/album';
import { AlbumService } from '../services/album.service';
import { FavorisService } from '../services/favoris.service';

@Component({
  selector: 'app-list-favoris',
  templateUrl: './list-favoris.component.html',
  styleUrl: './list-favoris.component.css'
})
export class ListFavorisComponent {
 favoris: any[] = [];
 albums: Album[] = [];
 constructor ( private FavorisService:FavorisService,
  private AlbumService :AlbumService
 ){}

 addToFavorites(album: any) {
  this.FavorisService.addFavorite(album);
  alert('Ajouté aux favoris !');
}
ngOnInit() {
  this.favoris= this.FavorisService.getFavorites();


  console.log(this.albums)

 console.log(this.favoris)
}
// Méthode pour supprimer un album des favoris
removeFromFavorites(album: any) {
  this.FavorisService.removeFavorite(album);
  this.favoris = this.FavorisService.getFavorites();
  alert('Album supprimé des favoris !');
}
}

