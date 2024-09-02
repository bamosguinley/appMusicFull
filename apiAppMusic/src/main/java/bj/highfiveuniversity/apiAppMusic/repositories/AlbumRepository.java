package bj.highfiveuniversity.apiAppMusic.repositories;

// Importation des classes nécessaires 
import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.apiAppMusic.models.Album;

/**
 * Interface `AlbumRepository` pour les opérations CRUD sur les albums.
 * 
 * <p>
 * Cette interface étend `JpaRepository`, ce qui lui permet de bénéficier
 * de méthodes prêtes à l'emploi pour l'accès aux données, telles que la
 * création,
 * la lecture, la mise à jour et la suppression d'albums dans la base de
 * données.
 * </p>
 * 
 * <p>
 * Elle prend en paramètres `Album` comme type d'entité et `Long` comme type
 * de l'identifiant de l'entité.
 * </p>
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
