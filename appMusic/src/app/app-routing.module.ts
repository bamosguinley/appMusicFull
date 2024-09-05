import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbumDescriptionComponent } from './album-description/album-description.component';
import { AlbumsComponent } from './albums/albums.component';
import { ListFavorisComponent } from './list-favoris/list-favoris.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  { path: 'albums', component: AlbumsComponent },
  { path: '', redirectTo: 'albums', pathMatch: 'full' },
  { path: 'album/:id', component: AlbumDescriptionComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
