package teste.hudson.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import teste.hudson.model.dto.CreateUserDTO;
import teste.hudson.model.entity.Usuario;
import teste.hudson.service.UsuarioService;
import teste.hudson.utils.CpfValidator;

import java.net.URI;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping(path = "id/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario user = service.findById(id);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<String> findById(@PathVariable String cpf) {
        Usuario user = service.findByCpf(cpf);

        if(!CpfValidator.isValid(cpf)){
            return ResponseEntity.badRequest().body("status: INVALID_CPF");
        }

        if (user == null) {
            return ResponseEntity.badRequest().body("status: UNABLE_TO_VOTE");
        }

        return ResponseEntity.ok().body("status: ABLE_TO_VOTE");
    }

    @PostMapping()
    public ResponseEntity<Usuario> create(@Valid @RequestBody CreateUserDTO dto) {
        Usuario usuario = service.dtoParaObj(dto);
        usuario = service.saveObj(usuario);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromContextPath(request).path("/usuario/{id}");
        URI uri = builder.buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }
}
