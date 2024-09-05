package bj.highfiveuniversity.apiAppMusic.services;


import com.github.javafaker.Faker;

import bj.highfiveuniversity.apiAppMusic.models.Album;
import bj.highfiveuniversity.apiAppMusic.models.Musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MusicFakerService {

    private final Faker faker = new Faker();

    @Autowired
    private MusiqueService musiqueService;

    @Autowired
    private AlbumService albumService;

    public Musique generateMusique(Album album) {
        Musique musique = new Musique();
        musique.setTitle(faker.music().instrument()); // Utilise le nom d'un instrument comme titre
        musique.setParoles(faker.lorem().paragraph()); // Génère un paragraphe comme paroles
        musique.setAlbum(album); // Associe l'album à la musique
        return musique;
    }
    

    public void generateMusiqueList(Long albumId, int count) {
    // Récupérer l'album à partir de l'ID
    Album album = albumService.getAlbumById(albumId);

    // Vérifier que l'album existe
    if (album == null) {
        throw new IllegalArgumentException("Album with ID " + albumId + " does not exist.");
    }

    // Générer les musiques et les associer à l'album
    for (int i = 0; i < count; i++) {
        Musique musique = generateMusique(album);
        musiqueService.createMusik(musique);
    }
}

}
