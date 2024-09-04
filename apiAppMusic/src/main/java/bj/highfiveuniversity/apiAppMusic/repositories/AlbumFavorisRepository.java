package bj.highfiveuniversity.apiAppMusic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.apiAppMusic.models.Album;
import bj.highfiveuniversity.apiAppMusic.models.AlbumFavoris;

public interface AlbumFavorisRepository extends JpaRepository<AlbumFavoris, Long> {

    List<AlbumFavoris> findByUserId(Long userId); 
    List<Album> findDistinctAlbumsByUserId(Long userId);
    
}
