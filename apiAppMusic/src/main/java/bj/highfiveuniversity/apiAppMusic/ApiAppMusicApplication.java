package bj.highfiveuniversity.apiAppMusic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bj.highfiveuniversity.apiAppMusic.services.AlbumFakerService;
import bj.highfiveuniversity.apiAppMusic.services.MusicFakerService;

@SpringBootApplication
public class ApiAppMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAppMusicApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AlbumFakerService albumFakerService, MusicFakerService musicFakerService) {
		return (args) -> {
			// albumFakerService.generateFakeAlbums(30);
			musicFakerService.generateMusiqueList(52L,10);
			musicFakerService.generateMusiqueList(53L,10);
			musicFakerService.generateMusiqueList(54L,10);
			musicFakerService.generateMusiqueList(55L,10);
			musicFakerService.generateMusiqueList(56L,10);
			musicFakerService.generateMusiqueList(57L,10);
			musicFakerService.generateMusiqueList(58L,10);
			musicFakerService.generateMusiqueList(59L,10);
			musicFakerService.generateMusiqueList(60L,10);
			musicFakerService.generateMusiqueList(61L,10);
		};
	}
}
