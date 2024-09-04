import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { catchError, of } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string | null = null;

  constructor(private authService: AuthService) {}

  onLogin(): void {
    this.authService.login(this.username, this.password).subscribe({
      next: (response) => {
         const token = response.token;
         if (token) {
           // Stocker le token dans le localStorage ou sessionStorage
           localStorage.setItem('authToken', token);

           // Rediriger l'utilisateur vers la page d'accueil ou une autre page
        //    this.router.navigate(['/home']);
         }
      },
      error: (error) => {
        this.errorMessage = error.error;
      },
    });
  }
}
