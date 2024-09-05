import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { Album } from '../interfaces/album';
import { AlbumService } from '../services/album.service';

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
      next: () => {
        Swal.fire('Succès!', 'L’album a été créé.', 'success');
        // Réinitialise le formulaire 
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
