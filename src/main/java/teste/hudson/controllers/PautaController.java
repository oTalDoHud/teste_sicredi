package teste.hudson.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "API Pauta")
public class PautaController {

    @Autowired
    private PautaService service;

    @GetMapping(path = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Proíbido"),
            @ApiResponse(code = 404, message = "Objeto não encontrado"),
    })
    @ApiOperation(value = "Busca por {id}")
    public ResponseEntity<Pauta> findById(@PathVariable Long id) {
        Pauta pauta = service.findById(id);

        return ResponseEntity.ok().body(pauta);
    }

    @PostMapping()
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Proíbido"),
            @ApiResponse(code = 404, message = "Objeto não encontrado"),
    })
    @ApiOperation(value = "Criar Pauta")
    public ResponseEntity<Pauta> create(@Valid @RequestBody CreatePautaDTO dto) {
        Pauta pauta = service.dtoParaObj(dto);
        pauta = service.saveObj(pauta);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromContextPath(request).path("/pauta/{id}");
        URI uri = builder.buildAndExpand(pauta.getId()).toUri();

        return ResponseEntity.created(uri).body(pauta);
    }
}
