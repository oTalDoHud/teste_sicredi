package teste.hudson.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import teste.hudson.model.dto.CreateUserDTO;
import teste.hudson.model.entity.Usuario;
import teste.hudson.repository.UsuarioRepository;
import teste.hudson.service.exception.CpfInvalidoException;
import teste.hudson.service.exception.ObjetoNaoEncontradoException;
import teste.hudson.utils.CpfValidator;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario findById(Long id) {
        Optional<Usuario> sessao = repository.findById(id);

        return sessao.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Usuário não encontrada! id: " + id + ". Tipo: " + Usuario.class.getSimpleName()
        ));
    }

    public Usuario findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Usuario dtoParaObj(CreateUserDTO dto) {

        if (!CpfValidator.isValid(dto.getCpf())) {
            throw new CpfInvalidoException("Cpf inválido");
        }

        return new Usuario(
                dto.getNome(),
                dto.getCpf()
        );
    }

    public Usuario saveObj(Usuario usuario) {
        return repository.save(usuario);
    }

}
