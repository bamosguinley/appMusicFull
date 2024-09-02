package bj.highfiveuniversity.apiAppMusic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.apiAppMusic.models.Musique;
import bj.highfiveuniversity.apiAppMusic.repositories.MusiqueRepository;

@Service
public class MusiqueService {
    @Autowired
    private MusiqueRepository musikRepository;

    public List<Musique> getAllMusiks() {
        return musikRepository.findAll();
    }

    
    public Musique getMusikById(Long id) {
        Musique musik = musikRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("aucune musique n'est trouvé"));
        return musik;
    }

    public Musique createMusik(Musique musik) {
        Musique newMusik = musikRepository.save(musik);
        return newMusik;

    }

    public Musique updateMusik(Long id, Musique musik ) {
        Musique musik2 = musikRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        musik2.setTitle(musik.getTitle());
        musik2.setParoles(musik.getParoles());
        return musik2;
    }

    public void deleteMusik(Long id) {
        musikRepository.deleteById(id);
    }
}
