package bj.highfiveuniversity.apiAppMusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.apiAppMusic.models.Musique;

public interface MusiqueRepository extends JpaRepository <Musique, Long> {
    
}
