package bj.highfiveuniversity.apiAppMusic.services;



import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bj.highfiveuniversity.apiAppMusic.models.Album;

import java.time.LocalDateTime;


@Service
public class AlbumFakerService {

    private final Faker faker;
    @Autowired
    public AlbumService albumService;

    public AlbumFakerService() {
        this.faker = new Faker();
    }

    public Album generateFakeAlbum() {
        Album album = new Album();
        album.setRef(faker.code().isbn13()); 
        album.setName(faker.book().title());
        album.setTitle(faker.book().author());
        album.setDescription(faker.lorem().paragraph());
        album.setDuration(faker.number().numberBetween(30, 120)); // Durée en minutes
        album.setCreatedAt(LocalDateTime.now());
        album.setUpdatedAt(LocalDateTime.now());
        System.out.println(album);
        return album;
    }

    public void generateFakeAlbums(int count) {
        for (int i = 0; i < count; i++) {
            albumService.createAlbum(generateFakeAlbum());
        }
    }
}
