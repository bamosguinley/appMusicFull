package bj.highfiveuniversity.apiAppMusic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bj.highfiveuniversity.apiAppMusic.services.AlbumFakerService;

@SpringBootApplication
public class ApiAppMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAppMusicApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner demo(AlbumFakerService albumFakerService) {
	// 	return (args) -> {
	// 		albumFakerService.generateFakeAlbums(30);
	// 	};
	// }
}
