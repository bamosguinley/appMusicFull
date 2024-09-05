import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AlbumService } from '../services/album.service';
import { Album } from '../interfaces/album';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-album-description',
  templateUrl: './album-description.component.html',
  styleUrl: './album-description.component.css',
})
export class AlbumDescriptionComponent {
  [x: string]: any;
  album?: Album;
  albums: Album[] = [];
  albumId?: string;



  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumService
  ) { }
  ngOnInit() {
    this.route.params.subscribe((params) => (this.albumId = params['id']));


    this.albumService.getAlbums().subscribe({
      next: (albums: Album[]) => {
        this.albums = albums;
        albums.forEach((album) => {
          this.albums?.push(album);
        });
        this.album = this.albums.filter((a) => a.id == this.albumId)[0];
        console.log(this.album + 'ffff');
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des albums:', err);
      },
    });

  }
  // Méthode pour modifier l'album
  modifyAlb(): void {
    if (this.album && this.albumId) {
      this.albumService.updateAlbum(this.albumId, this.album).subscribe({
        next: (updatedAlbum) => {
          console.log('Album mis à jour:', updatedAlbum);
          this['router'].navigate(['/albums']); // Redirection après la mise à jour
        },
        error: (error) => {
          console.error('Erreur lors de la mise à jour de l’album', error);
        }
      });
    } else {
      console.error('Données de l’album ou ID manquants pour la mise à jour.');
    }
  }



}


