package bj.highfiveuniversity.apiAppMusic.services;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import bj.highfiveuniversity.apiAppMusic.models.Album;
import bj.highfiveuniversity.apiAppMusic.repositories.AlbumRepository;

/**
 * Service pour générer et insérer des albums factices dans la base de données.
 */
@Service
public class FakerService {

    private final AlbumRepository albumRepository;
    private final Faker faker;

     /**
     * Constructeur pour l'injection des dépendances.
     *
     * @param albumRepository le repository des albums
     */
    public FakerService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
        this.faker = new Faker();
    }

    /**
     * Génère et sauvegarde 10 albums factices dans la base de données.
     */
    public void seedDatabase() {
        for (int i = 0; i < 10; i++) {
            String albumName = faker.company().name();
            String albumRef = faker.idNumber().valid();
            String albumTitle = faker.book().title();
            String albumDescription = faker.lorem().paragraph();
            int albumDuration = faker.number().numberBetween(1, 3600);

            Album album = Album.builder()
                    .ref(albumRef)
                    .title(albumTitle)
                    .name(albumName)
                    .description(albumDescription)
                    .duration(albumDuration)
                    .build();

            albumRepository.save(album);
        }
    }
}
