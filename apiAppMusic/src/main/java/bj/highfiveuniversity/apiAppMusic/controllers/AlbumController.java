package bj.highfiveuniversity.apiAppMusic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.apiAppMusic.models.Album;
import bj.highfiveuniversity.apiAppMusic.services.AlbumService;

@RestController
@RequestMapping("auth/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> getAllAlbum() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Album album = albumService.getAlbumById(id);
        return ResponseEntity.ok(album);
    }

    @PostMapping()
    public ResponseEntity<Album> createalbum(@RequestBody Album album) {
        Album newalbum = albumService.createAlbum(album);
        return ResponseEntity.ok(newalbum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> updatealbum(@PathVariable Long id, @RequestBody Album album) {
        Album albumToUpdate = albumService.updateAlbum(id, album);
        return ResponseEntity.ok(albumToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletealbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }
}