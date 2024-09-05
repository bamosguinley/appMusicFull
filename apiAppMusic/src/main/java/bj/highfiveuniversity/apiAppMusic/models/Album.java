package bj.highfiveuniversity.apiAppMusic.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.websocket.Decoder.Text;
import jakarta.persistence.GeneratedValue;
import lombok.Builder;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="albums")
@Builder
public class Album {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ref")
    private String ref;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    
    @Column(name = "description" )
    @Lob
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "album")
    private List<AlbumFavoris> albumFavoris;


    
    @OneToMany(mappedBy = "album")
    private List<Musique> musiques;
}
