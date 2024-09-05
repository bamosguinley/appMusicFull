import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Album } from '../interfaces/album';
import { AlbumService } from '../services/album.service';

@Component({
  selector: 'app-album-description',
  templateUrl: './album-description.component.html',
  styleUrl: './album-description.component.css',
})
export class AlbumDescriptionComponent {
  album?: Album;
  albums: Album[] = [];
  albumId?: string;
  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumService
  ) {}
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
}
