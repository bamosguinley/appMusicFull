package bj.highfiveuniversity.apiAppMusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application `ApiAppMusicApplication`.
 * 
 * <p>
 * Cette classe est le point d'entrée de l'application Spring Boot et utilise
 * l'annotation
 * `@SpringBootApplication` pour activer la configuration automatique, le scan
 * des composants
 * et d'autres fonctionnalités de base de Spring Boot.
 * </p>
 */
@SpringBootApplication
public class ApiAppMusicApplication {
	/**
	 * Méthode principale (main) de l'application.
	 * 
	 * <p>
	 * Cette méthode lance l'application Spring Boot en appelant
	 * `SpringApplication.run()`
	 * avec les arguments passés en ligne de commande.
	 * </p>
	 * 
	 * @param args les arguments de la ligne de commande passés à l'application.
	 */
	public static void main(String[] args) {
		// Lancement de l'application Spring Boot
		SpringApplication.run(ApiAppMusicApplication.class, args);
	}

}
