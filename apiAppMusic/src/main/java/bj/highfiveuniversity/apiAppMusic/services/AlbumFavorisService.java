package bj.highfiveuniversity.apiAppMusic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bj.highfiveuniversity.apiAppMusic.models.Album;
import bj.highfiveuniversity.apiAppMusic.models.AlbumFavoris;
import bj.highfiveuniversity.apiAppMusic.models.User;
import bj.highfiveuniversity.apiAppMusic.repositories.AlbumFavorisRepository;
import bj.highfiveuniversity.apiAppMusic.repositories.AlbumRepository;
import bj.highfiveuniversity.apiAppMusic.repositories.UserRepository;

public class AlbumFavorisService {

     @Autowired
    private AlbumFavorisRepository albumFavorisRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlbumRepository albumRepository;

   
    public AlbumFavoris addAlbumFavoris(Long userId, Long albumId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album not found"));
        AlbumFavoris albumFavoris = new AlbumFavoris();
        albumFavoris.setUser(user);
        albumFavoris.setAlbum(album);
        return albumFavorisRepository.save(albumFavoris);
    }
    
    public List<Album> getAllFavoriteAlbumsByUser(Long userId) {
        return albumFavorisRepository.findDistinctAlbumsByUserId(userId);
    }
    
    public void deleteAlbumFavoris(Long albumFavorisId) {
        albumFavorisRepository.deleteById(albumFavorisId);
    }
}
