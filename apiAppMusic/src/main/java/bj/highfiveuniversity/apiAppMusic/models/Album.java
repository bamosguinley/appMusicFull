package bj.highfiveuniversity.apiAppMusic.models;
// Importation des classes nécessaires pour les annotations et les types de données

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe représentant un Album.
 * Cette classe utilise les annotations JPA pour définir la structure de la
 * table albums dans la base de données.
 * Elle inclut également des annotations Lombok pour générer automatiquement les
 * méthodes getter, setter et constructeurs.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "albums")
public class Album {
    /**
     * Identifiant unique de l'album.
     * Généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * Référence unique de l'album.
     * Ne peut pas être nul et doit être unique dans la base de données.
     */
    @Column(name = "ref", unique = true, nullable = false)

    private String ref;
    /**
     * Nom de l'album.
     * Ce champ est obligatoire.
     */

    @Column(name = "name", nullable = false)
    private String name;
    /**
     * Titre de l'album.
     * Ce champ est obligatoire et ne peut pas être nul.
     */
    @Column(name = "title", nullable = false)
    private String title;
    /**
     * Description de l'album.
     * Peut contenir des informations supplémentaires sur l'album.
     */
    @Column(name = "description")
    private String description;
    /**
     * Durée totale de l'album en minutes.
     * Représente le temps total des pistes incluses dans l'album.
     */
    @Column(name = "duration")
    private Integer duration;
    /**
     * Date et heure de création de l'album.
     * Ce champ est défini lors de l'insertion et ne peut pas être modifié par la
     * suite.
     */
    @Column(updatable = false)
    private LocalDateTime createdAt;
    /**
     * Date et heure de la dernière mise à jour de l'album.
     * Mis à jour automatiquement à chaque modification de l'album.
     */
    private LocalDateTime updatedAt;

}
