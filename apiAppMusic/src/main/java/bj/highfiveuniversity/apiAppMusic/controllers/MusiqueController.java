package bj.highfiveuniversity.apiAppMusic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.apiAppMusic.models.Musique;

import bj.highfiveuniversity.apiAppMusic.services.MusiqueService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/musiques")
@CrossOrigin("*")
public class MusiqueController {
    @Autowired
    MusiqueService musikService;

    @GetMapping
    public List<Musique> getAllMusik() {
        return musikService.getAllMusiks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musique> getMusikById(@PathVariable Long id) {
        Musique musik = musikService.getMusikById(id);
        return ResponseEntity.ok(musik);
    }

    @PostMapping()
    public ResponseEntity<Musique> createMusik(@RequestBody Musique musik) {
        Musique newMusik = musikService.createMusik(musik);

        return ResponseEntity.ok(newMusik);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musique> updateMusik(@PathVariable Long id, @RequestBody Musique musik) {
        Musique musikUpdate = musikService.updateMusik(id, musik);
        return ResponseEntity.ok(musikUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusik(@PathVariable Long id) {
        musikService.deleteMusik(id);
        return ResponseEntity.noContent().build();
    }
}
