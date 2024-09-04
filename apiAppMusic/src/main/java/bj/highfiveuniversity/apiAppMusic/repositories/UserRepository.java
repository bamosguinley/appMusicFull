package bj.highfiveuniversity.apiAppMusic.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bj.highfiveuniversity.apiAppMusic.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);}
