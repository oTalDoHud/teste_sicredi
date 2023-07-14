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
import teste.hudson.model.dto.CreatePautaDTO;
import teste.hudson.model.entity.Pauta;
import teste.hudson.service.PautaService;

import java.net.URI;

@RestController
@RequestMapping("/pauta")
@AllArgsConstructor
public class PautaController {

    private final PautaService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pauta> findById(@PathVariable Long id) {
        Pauta pauta = service.findById(id);

        return ResponseEntity.ok().body(pauta);
    }

    @PostMapping()
    public ResponseEntity<Pauta> create(@Valid @RequestBody CreatePautaDTO dto) {
        Pauta pauta = service.dtoParaObj(dto);
        pauta = service.saveObj(pauta);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromContextPath(request).path("/pauta/{id}");
        URI uri = builder.buildAndExpand(pauta.getId()).toUri();

        return ResponseEntity.created(uri).body(pauta);
    }
}
