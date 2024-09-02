package bj.highfiveuniversity.apiAppMusic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.apiAppMusic.models.Musik;
import bj.highfiveuniversity.apiAppMusic.repositories.MusikRepository;

@Service
public class MusikService {
    @Autowired
    private MusikRepository musikRepository;

    public List<Musik> getAllMusiks() {
        return musikRepository.findAll();
    }

    public Musik getMusikByMusik(Long id) {
        Musik musik = musikRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("aucune musique n'est trouvé"));
        return musik;
    }

    public Musik createMusik(Musik musik) {
        Musik newMusik = musikRepository.save(musik);
        return newMusik;

    }

    public Musik updateMusik(Musik musik, Long id) {
        Musik musik2 = musikRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        musik2.setTitle(musik2.getTitle());
        musik2.setParoles(musik2.getParoles());
        return musik2;
    }

    public void deleteMusik(Long id) {
        musikRepository.deleteById(id);
    }
}
