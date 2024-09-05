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

    public Musique generateMusique() {
        // Album currentAlb = albumService.findById("11");
        Musique musique = new Musique();
        musique.setTitle(faker.music().instrument()); // Utilise le nom d'un instrument comme titre
        musique.setParoles(faker.lorem().paragraph()); // Génère un paragraphe comme paroles

        // Associe un album existant
        // musique.setAlbum(album);
        return musique;
    }

    // Pour générer une liste de musiques fictives
    public void generateMusiqueList(Album album, int count) {
       
        for (int i = 0; i < count; i++) {
            // musiqueService.createMusik(generateMusique(album));
        }
    }
}
