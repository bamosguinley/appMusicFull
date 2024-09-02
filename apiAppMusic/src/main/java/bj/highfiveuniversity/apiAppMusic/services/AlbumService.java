package bj.highfiveuniversity.apiAppMusic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.apiAppMusic.models.Album;
import bj.highfiveuniversity.apiAppMusic.repositories.AlbumRepository;

/**
 * Service pour la gestion des albums.
 * Fournit les méthodes pour effectuer les opérations CRUD sur les albums.
 */
@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    /**
     * Récupère la liste de tous les albums.
     * 
     * @return une liste contenant tous les albums disponibles.
     */
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    /**
     * Récupère un album par son identifiant.
     * 
     * @param id l'identifiant de l'album à récupérer.
     * @return l'album correspondant à l'identifiant fourni.
     * @throws RuntimeException si aucun album n'est trouvé avec l'identifiant
     *                          donné.
     */
    public Album getAlbumById(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucun album trouvé"));
        return album;
    }

    /**
     * Crée un nouvel album dans la base de données.
     * 
     * @param album l'album à créer.
     * @return l'album nouvellement créé.
     */
    public Album createAlbum(Album album) {
        Album newAlbum = albumRepository.save(album);
        return newAlbum;
    }

    /**
     * Met à jour un album existant avec les nouvelles informations fournies.
     * 
     * @param id    l'identifiant de l'album à mettre à jour.
     * @param album l'objet album contenant les nouvelles informations.
     * @return l'album mis à jour.
     * @throws RuntimeException si aucun album n'est trouvé avec l'identifiant
     *                          donné.
     */
    public Album updateAlbum(Long id, Album album) {
        // Cherche l'album à mettre à jour, lance une exception s'il n'est pas trouvé

        Album albumToUpdate = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album avec l'id " + id + " non trouvé"));
        // Mise à jour des champs de l'album avec les nouvelles valeurs

        albumToUpdate.setRef(album.getRef());
        albumToUpdate.setName(album.getName());
        albumToUpdate.setTitle(album.getTitle());
        albumToUpdate.setDescription(album.getDescription());
        albumToUpdate.setDuration(album.getDuration());
        // Sauvegarde des modifications
        return albumToUpdate;
    }

    /**
     * Supprime un album par son identifiant.
     * 
     * @param id l'identifiant de l'album à supprimer.
     */
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
