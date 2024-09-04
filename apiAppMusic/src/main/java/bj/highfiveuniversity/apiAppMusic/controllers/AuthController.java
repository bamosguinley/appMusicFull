package bj.highfiveuniversity.apiAppMusic.controllers;

import bj.highfiveuniversity.apiAppMusic.models.User;
import bj.highfiveuniversity.apiAppMusic.services.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String username, @RequestParam String password) {
        try {
            userService.registerUser(username, password);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        System.out.println(username +"nom");
        User user = userService.findByUsername(username);
        if (user != null && userService.getPasswordEncoder().matches(password, user.getPassword())) {
             // Génère un token simple (remplace cela par une véritable génération de JWT)
            String token = "dummy-token-for-" + username;

            // Crée une réponse avec le token
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        // Réponse en cas d'échec de l'authentification
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Invalid credentials");
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
