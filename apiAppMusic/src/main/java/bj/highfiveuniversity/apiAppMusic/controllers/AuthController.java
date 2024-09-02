package bj.highfiveuniversity.apiAppMusic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.apiAppMusic.models.User;
import bj.highfiveuniversity.apiAppMusic.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
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
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.findByUsername(username);
        if (user != null && userService.getPasswordEncoder().matches(password, user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }
}
