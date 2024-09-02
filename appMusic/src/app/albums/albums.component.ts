import { Component, Input } from '@angular/core';
import { Album } from '../interfaces/album';
import { AlbumService } from '../services/album.service';
import { FavorisService } from '../services/favoris.service';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrl: './albums.component.css',
})
export class AlbumsComponent {
  queryString: string = '';
  albums: Album[] = [];
  albumId: string = '';
  loader: boolean = true;
  loaderCount?: any;
  filtererdAlbum: Album[] = [];

  displayedAlbums: Album[] = []; //les données de pagination à afficher

  currentPage: number = 1; //page courrante

  pageNumber: number = 1; //nombre de page

  albumsPerPage: number = 2; //nombre d'album par page

  pageNumbers?: number[]; //numero des pages
  totalPages!:number; //nombre total de pages

  item: any;
  favoris:any =[];
  items:any[]=[];

  @Input() sendPlayingAlbum: string = '';
  constructor(private albumService: AlbumService,
    private FavorisService: FavorisService
  
  ) {}
  ngOnInit() {
    this.albums = this.albumService.getAlbums();
    this.totalPages = this.albumService.getAlbums().length / 2;
    this.updatePageNumbers();
    console.log(this.pageNumbers+'nbr');
    
    this.loadAlbums();
    this.startLoading();
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
    this.filterItems();
  }

  public filterItems(): void {
    if (this.queryString.trim().length > 0) {
      this.displayedAlbums = this.albums.filter((item) =>
        item.name.toLowerCase().includes(this.queryString.toLowerCase())
      );
    } else {
      this.butnPages(this.currentPage);
    }
  }

  getAlbumForPlay(e: string) {
    console.log(e);
    this.sendPlayingAlbum = e;
  }

  loadAlbums() {
    const startIndex = (this.currentPage - 1) * this.albumsPerPage;
    const endIndex = startIndex + this.albumsPerPage;
    this.displayedAlbums = this.albums.slice(startIndex, endIndex);
  }

  butnPages(n: number) {
    this.currentPage = n;
    this.loadAlbums();
  }
  nextPage() {
    this.currentPage++;
    this.loadAlbums();
  }

  previousPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.loadAlbums();
    }
  }

  updatePageNumbers(): void {
    const range = 10;
    const start = Math.max(1, this.currentPage - range);
    const end = Math.min(this.totalPages, this.currentPage + range);
    this.pageNumbers = Array.from(
      { length: end - start + 1 },
      (_, i) => start + i
    );
  }
//   addToFavorites(albumId:string) {
//     this.FavorisService.addFavorite(albumId);
//    // Récupérer l'album en utilisant l'ID
//    const album = this.getAlbumById(albumId);
//    if (album) {
//      this.FavorisService.addFavorite(album);
//      alert('Album ajouté aux favoris !');
//    } else {
//      alert('Album non trouvé !');
//    }
    
// }

  // Méthode pour ajouter ou retirer un album des favoris
  toggleFavorite(albumId: string) {
    const album = this.getAlbumById(albumId);
    if (album) {
      if (this.isFavorite(albumId)) {
        this.FavorisService.removeFavorite(album);
        alert('Album retiré des favoris !');
      } else {
        this.FavorisService.addFavorite(album);
        alert('Album ajouté aux favoris !');
      }
    } else {
      alert('Album non trouvé !');
    }
  }

   // Vérifie si un album est déjà dans les favoris
   isFavorite(albumId:string): boolean {
    return this.FavorisService.getFavorites().some(fav => fav.id === albumId);
  }
getAlbumById(id: String) {
  return this.albums.find(album => album.id === id);
}
}