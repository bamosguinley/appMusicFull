import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Album } from '../interfaces/album';
import { AlbumService } from '../services/album.service';
import { MusicService } from '../services/music.service';

@Component({
  selector: 'app-album-description',
  templateUrl: './album-description.component.html',
  styleUrl: './album-description.component.css',
})
export class AlbumDescriptionComponent {
  album?: Album;
  albums: Album[] = [];
  albumId?: string;
  musicTitle: string = '';  // Pour le titre de la musique
  musicParoles: string = ''; // Pour les paroles de la musique



  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumService,
    private musicService: MusicService // Injection du service de musique
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

  onSubmit() {
    console.log('Formulaire soumis');
    if (this.albumId) {
      const musicData = {
        title: this.musicTitle,
        paroles: this.musicParoles
      };
      this.musicService.addMusicToAlbum(this.albumId, musicData).subscribe({
        next: () => {
          console.log('Musique ajoutée avec succès');
          // Réinitialisation des champs du formulaire après l'ajout
          this.musicTitle = '';
          this.musicParoles = '';
          // Recharger les informations de l'album
          this.ngOnInit(); // Recharge des données de l'album pour afficher les nouvelles informations
        },
        error: (err) => {
          console.error('Erreur lors de l\'ajout de la musique', err);
        }
      });
    }
  }

}
