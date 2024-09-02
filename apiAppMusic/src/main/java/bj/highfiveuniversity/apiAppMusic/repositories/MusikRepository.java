package bj.highfiveuniversity.apiAppMusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.apiAppMusic.models.Musik;

public interface MusikRepository extends JpaRepository <Musik, Long> {
    
}
