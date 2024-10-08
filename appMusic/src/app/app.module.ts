import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlbumDescriptionComponent } from './album-description/album-description.component';
import { AlbumDetailsComponent } from './album-details/album-details.component';
import { AlbumPlayerComponent } from './album-player/album-player.component';
import { AlbumSearchComponent } from './album-search/album-search.component';
import { AlbumsComponent } from './albums/albums.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    AlbumDescriptionComponent,
    AlbumDetailsComponent,
    AlbumPlayerComponent,
    AlbumSearchComponent,
    AlbumsComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
