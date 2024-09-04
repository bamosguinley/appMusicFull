import { Component } from '@angular/core';
import { AlbumService } from '../services/album.service';
import { Album } from '../interfaces/album';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-album-create-form',
  templateUrl: './album-create-form.component.html',
  styleUrl: './album-create-form.component.css',
})
export class AlbumCreateFormComponent {
  newAlbum: Album = {
    title: '',
    id: '',
    ref: '',
    name: '',
    description: '',
    duration: 0
  }; // Modifiez selon votre modèle

  constructor(private albumService: AlbumService) {}

  createAlbum(): void {
    this.albumService.createAlbum(this.newAlbum).subscribe({
      next: (album) => {
        Swal.fire('Succès!', 'L’album a été créé.', 'success');
        // Réinitialisez le formulaire ou redirigez vers une autre page si nécessaire
        this.newAlbum = {
          title: '',
          id: '',
          ref: '',
          name: '',
          description: '',
          duration: 0,
        };
      },
      error: (err) => {
        console.error('Erreur lors de la création de l’album', err);
        Swal.fire(
          'Erreur!',
          'Une erreur est survenue lors de la création de l’album.',
          'error'
        );
      },
    });
  }
}
