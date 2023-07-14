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
import teste.hudson.model.dto.CreateSessaoDTO;
import teste.hudson.model.dto.VotoDTO;
import teste.hudson.model.entity.Sessao;
import teste.hudson.model.entity.SessaoDTO;
import teste.hudson.service.SessaoService;

import java.net.URI;

@RestController
@RequestMapping("/sessao")
@AllArgsConstructor
public class SessaoController {

    private final SessaoService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<SessaoDTO> findById(@PathVariable Long id) {
        SessaoDTO sessaoDTO = service.preFindById(id);

        return ResponseEntity.ok().body(sessaoDTO);
    }

    @PostMapping()
    public ResponseEntity<Sessao> create(@Valid @RequestBody CreateSessaoDTO dto) {
        Sessao sessao = service.dtoParaObj(dto);
        sessao = service.saveObj(sessao);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromContextPath(request).path("/sessao/{id}");
        URI uri = builder.buildAndExpand(sessao.getId()).toUri();

        return ResponseEntity.created(uri).body(sessao);
    }

    @PostMapping(path = "/voto")
    public ResponseEntity<String> votos(@Valid @RequestBody VotoDTO dto) {
        return ResponseEntity.ok(service.votar(dto));
    }

}
