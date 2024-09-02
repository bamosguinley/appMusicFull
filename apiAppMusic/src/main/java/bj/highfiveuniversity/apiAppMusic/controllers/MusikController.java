package bj.highfiveuniversity.apiAppMusic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.apiAppMusic.models.Musik;

import bj.highfiveuniversity.apiAppMusic.services.MusikService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/apiAppMusic/musiks")
public class MusikController {
    @Autowired
    MusikService musikService;

    @GetMapping
    public List<Musik> getAllMusik() {
        return musikService.getAllMusiks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musik> getMusikById(@PathVariable Long id) {
        Musik musik = musikService.getMusikById(id);
        return ResponseEntity.ok(musik);
    }

    @PostMapping()
    public ResponseEntity<Musik> createMusik(@RequestBody Musik musik) {
        Musik newMusik = musikService.createMusik(musik);

        return ResponseEntity.ok(newMusik);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musik> updateMusik(@PathVariable Long id, @RequestBody Musik musik) {
        Musik musikUpdate = musikService.updateMusik(id, musik);

        return ResponseEntity.ok(musikUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusik(@PathVariable Long id) {
        musikService.deleteMusik(id);
        return ResponseEntity.noContent().build();
    }
}
