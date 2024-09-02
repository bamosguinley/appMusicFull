import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbumDescriptionComponent } from './album-description/album-description.component';
import { AlbumsComponent } from './albums/albums.component';
import { ListFavorisComponent } from './list-favoris/list-favoris.component';
import { LoginComponent } from './login/login.component';
<<<<<<< HEAD
=======
import { RegisterComponent } from './register/register.component';

>>>>>>> 82a69db (add auth)
const routes: Routes = [
  { path: 'albums', component: AlbumsComponent },
  { path: '', redirectTo: 'albums', pathMatch: 'full' },
  { path: 'album/:id', component: AlbumDescriptionComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
<<<<<<< HEAD
  { path: 'favoris', component: ListFavorisComponent  },

=======
  { path: '', redirectTo: '/login', pathMatch: 'full' },
>>>>>>> 82a69db (add auth)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
