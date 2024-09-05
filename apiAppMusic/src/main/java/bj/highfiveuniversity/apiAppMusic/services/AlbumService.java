package bj.highfiveuniversity.apiAppMusic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.apiAppMusic.models.Album;
import bj.highfiveuniversity.apiAppMusic.repositories.AlbumRepository;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    // @Autowired
    // private FileStorageService fileStorageService;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucun album trouvé"));
        return album;
    }

    public Album createAlbum(Album album) {
        Album newAlbum = albumRepository.save(album);
        return newAlbum;
    }

    public Album updateAlbum(Long id, Album album) {
        Album albumToUpdate = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album avec l'id " + id + " non trouvé"));
        albumToUpdate.setRef(album.getRef());
        albumToUpdate.setName(album.getName());
        albumToUpdate.setTitle(album.getTitle());
        albumToUpdate.setDescription(album.getDescription());
        albumToUpdate.setDuration(album.getDuration());
        return albumToUpdate;
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
