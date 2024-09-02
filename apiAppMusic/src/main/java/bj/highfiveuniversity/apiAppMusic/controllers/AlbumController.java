package bj.highfiveuniversity.apiAppMusic.controllers;

// Importation des classes nécessaires
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

/**
 * Contrôleur REST pour gérer les opérations CRUD sur les albums.
 * Fournit des endpoints pour créer, lire, mettre à jour et supprimer des
 * albums.
 */
@RestController
@RequestMapping("api/albums")

public class AlbumController {
    /**
     * Service pour la gestion des albums.
     * Injecté automatiquement par Spring.
     */
    @Autowired
    private AlbumService albumService;

    /**
     * Récupère la liste de tous les albums.
     *
     * @return Liste des albums.
     */
    @GetMapping
    public List<Album> getAllAlbum() {
        return albumService.getAllAlbums();
    }

    /**
     * Récupère un album spécifique par son identifiant.
     *
     * @param id Identifiant de l'album à récupérer.
     * @return Réponse HTTP contenant l'album demandé avec le statut 200 OK.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Album album = albumService.getAlbumById(id);
        return ResponseEntity.ok(album);
    }

    /**
     * Crée un nouvel album.
     *
     * @param album Objet Album à créer.
     * @return Réponse HTTP contenant le nouvel album créé avec le statut 200 OK.
     */

    @PostMapping()
    public ResponseEntity<Album> createalbum(@RequestBody Album album) {
        Album newalbum = albumService.createAlbum(album);
        return ResponseEntity.ok(newalbum);
    }

    /**
     * Met à jour un album existant.
     *
     * @param id    Identifiant de l'album à mettre à jour.
     * @param album Objet Album contenant les nouvelles données.
     * @return Réponse HTTP contenant l'album mis à jour avec le statut 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Album> updatealbum(@PathVariable Long id, @RequestBody Album album) {
        Album albumToUpdate = albumService.updateAlbum(id, album);
        return ResponseEntity.ok(albumToUpdate);
    }

    /**
     * Supprime un album par son identifiant.
     *
     * @param id Identifiant de l'album à supprimer.
     * @return Réponse HTTP avec le statut 204 No Content pour indiquer que la
     *         suppression a réussi.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletealbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }
}