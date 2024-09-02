package bj.highfiveuniversity.apiAppMusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.apiAppMusic.models.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
