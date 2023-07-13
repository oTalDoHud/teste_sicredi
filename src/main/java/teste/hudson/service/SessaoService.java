package teste.hudson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teste.hudson.model.dto.CreateSessaoDTO;
import teste.hudson.model.entity.Pauta;
import teste.hudson.model.entity.Sessao;
import teste.hudson.model.enums.FuncionamentoSessao;
import teste.hudson.repository.SessaoRepository;
import teste.hudson.service.exception.ObjetoNaoEncontradoException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository repository;

    @Autowired
    private PautaService pautaService;

    public Sessao findById(Long id) {
        Optional<Sessao> sessao = repository.findById(id);

        return sessao.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Sessão não encontrada! id: " + id + ". Tipo: " + Sessao.class.getSimpleName()
        ));
    }

    public Sessao dtoParaObj(CreateSessaoDTO dto) {
        Pauta pauta = pautaService.findById(dto.getPauta());

        return new Sessao(
                pauta,
                null,
                FuncionamentoSessao.ATIVA,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(dto.getDuracaoMinutos() != null ? dto.getDuracaoMinutos() : 1)
        );
    }

    public Sessao saveObj(Sessao sessao) {
        return repository.save(sessao);
    }

}
