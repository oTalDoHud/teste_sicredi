package teste.hudson.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import teste.hudson.model.dto.CreateSessaoDTO;
import teste.hudson.model.dto.VotoDTO;
import teste.hudson.model.entity.Sessao;
import teste.hudson.model.entity.SessaoDTO;
import teste.hudson.model.entity.Usuario;
import teste.hudson.model.enums.FuncionamentoSessao;
import teste.hudson.model.enums.Votos;
import teste.hudson.repository.SessaoRepository;
import teste.hudson.service.exception.ObjetoNaoEncontradoException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SessaoService {

    private final SessaoRepository repository;

    private final PautaService pautaService;

    private final UsuarioService usuarioService;

    public Sessao findById(Long id) {
        Optional<Sessao> sessao = repository.findById(id);

        return sessao.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Sessão não encontrada! id: " + id + ". Tipo: " + Sessao.class.getSimpleName()
        ));
    }

    public SessaoDTO preFindById(Long id) {
        var sessao = findById(id);

        return new SessaoDTO(sessao);
    }

    public Sessao dtoParaObj(CreateSessaoDTO dto) {
        var pauta = pautaService.findById(dto.getPauta());

        return new Sessao(
                0,
                0,
                FuncionamentoSessao.ATIVA,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(dto.getDuracaoMinutos() != null ? dto.getDuracaoMinutos() : 1),
                pauta
        );
    }

    public Sessao saveObj(Sessao sessao) {
        return repository.save(sessao);
    }

    public String votar(VotoDTO dto) {
        var sessao = findById(dto.getSessao());

        if (Objects.equals(FuncionamentoSessao.INATIVA.getCod(), sessao.getFuncionamentoSessao().getCod())) {
            return String.format("Sessão %d finalizada. Voto não registrado", sessao.getId());
        }

        if (LocalDateTime.now().isAfter(sessao.getFinalSessao())) {
            sessao.setFuncionamentoSessao(FuncionamentoSessao.INATIVA);
            saveObj(sessao);
            return String.format("Sessão %d finalizada. Voto não registrado", sessao.getId());
        }

        var usuario = usuarioService.findByCpf(dto.getCpf());

        if (usuario == null) {
            return "Usuário inválido, voto não registrado.";
        }

        boolean match = sessao.getUsuarios().stream().map(Usuario::getCpf).anyMatch(
                cpf -> cpf.equals(dto.getCpf()));

        if (match) {
            return "Você já votou nessa sessão.";
        }

        if (dto.getVoto() == Votos.SIM.getCod()) {
            sessao.addVotoSim();
        } else {
            sessao.addVotoNao();
        }

        sessao.getUsuarios().add(usuario);

        saveObj(sessao);

        return "Voto realizado com sucesso.";
    }
}
