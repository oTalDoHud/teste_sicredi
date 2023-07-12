package teste.hudson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teste.hudson.model.dto.CreatePautaDTO;
import teste.hudson.model.entity.Pauta;
import teste.hudson.repository.PautaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PautaService {

    @Autowired
    private PautaRepository repository;

    public Pauta dtoParaObj(CreatePautaDTO dto) {
        return new Pauta(
                dto.getAssuntoPauta(),
                dto.getDsPauta(),
                LocalDateTime.now()
        );
    }

    public Pauta saveObj(Pauta pauta) {
        return repository.save(pauta);
    }

    public Pauta findById(Long id) {
        Optional<Pauta> pauta = repository.findById(id);

        return pauta.get();
    }
}
