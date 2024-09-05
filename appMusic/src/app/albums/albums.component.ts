import { Component, Input } from '@angular/core';
import { Album } from '../interfaces/album';
import { List } from '../interfaces/list';
import { AlbumService } from '../services/album.service';
import { FavorisService } from '../services/favoris.service';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrl: './albums.component.css',
})
export class AlbumsComponent {
  queryString: string = '';
  albums: Album[]=[] ;
  albumId: string = '';
  loader: boolean = true;
  loaderCount?: any;
  filtererdAlbum: Album[] = [];

  // displayedAlbums: Album[] = []; //les données de pagination à afficher

  currentPage: number = 1; //page courrante

  // pageNumber: number = 1; //nombre de page

  // albumsPerPage: number = 2; //nombre d'album par page

  // pageNumbers?: number[]; //numero des pages
  // totalPages!: number; //nombre total de pages

  @Input() sendPlayingAlbum: string = '';
  constructor(private albumService: AlbumService,
    private FavorisService: FavorisService
  
  ) {}
  ngOnInit() {
  
    this.loadAlbums();
    this.startLoading();
  }

  loadAlbums(): void {
    this.albumService.getAlbums().subscribe({
      next: (albums: Album[]) => {
        this.albums = albums;
        albums.forEach(album => {
         console.log(album);
          this.albums?.push(album);
        });
        // this.totalPages = Math.ceil(this.albums.length / 2); // Calculer le nombre total de pages
        // this.updatePageNumbers();
        // console.log(this.pageNumbers + ' nbr');
        // console.log(albums);
        
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des albums:', err);
      },
    });
  }

  loadSongs(): void {
    this.albumService.getSongs().subscribe({
      next: (songs: List []) => {
        // this.albumsSongs = songs;
        // Vous pouvez ajouter du code ici pour gérer les chansons si nécessaire
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des chansons:', err);
      },
    });
  }




  startLoading() {
    this.loaderCount = setTimeout(() => {
      this.loader = false;
      console.log(this.loader);
    }, 2000);
  }

  getAlbum(albumId: string) {
    this.albumId = albumId;
  }

  handleSearch(query: string): void {
    this.queryString = query;
    console.log(this.queryString);
    // this.filterItems();
  }

  // public filterItems(): void {
  //   if (this.queryString.trim().length > 0) {
  //     this.displayedAlbums = this.albums.filter((item) =>
  //       item.name.toLowerCase().includes(this.queryString.toLowerCase())
  //     );
  //   } else {
  //     this.butnPages(this.currentPage);
  //   }
  // }

  getAlbumForPlay(e: string) {
    console.log(e);
    this.sendPlayingAlbum = e;
  }



  // butnPages(n: number) {
  //   this.currentPage = n;
  //   this.loadAlbums();
  // }
  // nextPage() {
  //   this.currentPage++;
  //   this.loadAlbums();
  // }

  // previousPage() {
  //   if (this.currentPage > 1) {
  //     this.currentPage--;
  //     this.loadAlbums();
  //   }
  // }

  // updatePageNumbers(): void {
  //   const range = 10;
  //   const start = Math.max(1, this.currentPage - range);
  //   const end = Math.min(this.totalPages, this.currentPage + range);
  //   this.pageNumbers = Array.from(
  //     { length: end - start + 1 },
  //     (_, i) => start + i
  //   );
  // }
}
