import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  username: string = '';
  password: string = '';
  errorMessage: string | null = null;

  constructor(private authService: AuthService) {}

  onRegister(): void {
    this.authService.register(this.username, this.password).subscribe({
      next: () => {
        // Rediriger vers la page de connexion ou d'accueil
        // this.router.navigate(['/login']);
      },
      error: (error) => {
        this.errorMessage = error.error;
      },
    });
  }
}
