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
import teste.hudson.model.dto.CreateSessaoDTO;
import teste.hudson.model.entity.Sessao;
import teste.hudson.service.SessaoService;

import java.net.URI;

@RestController
@RequestMapping("/sessao")
@Api(value = "API Sessão")
public class SessaoController {

    @Autowired
    private SessaoService service;

    @GetMapping(path = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Proíbido"),
            @ApiResponse(code = 404, message = "Objeto não encontrado"),
    })
    @ApiOperation(value = "Busca por {id}")
    public ResponseEntity<Sessao> findById(@PathVariable Long id) {
        Sessao sessao = service.findById(id);

        return ResponseEntity.ok().body(sessao);
    }

    @PostMapping()
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Proíbido"),
            @ApiResponse(code = 404, message = "Objeto não encontrado"),
    })
    @ApiOperation(value = "Criar Pauta")
    public ResponseEntity<Sessao> create(@Valid @RequestBody CreateSessaoDTO dto) {
        Sessao sessao = service.dtoParaObj(dto);
        sessao = service.saveObj(sessao);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromContextPath(request).path("/sessao/{id}");
        URI uri = builder.buildAndExpand(sessao.getId()).toUri();

        return ResponseEntity.created(uri).body(sessao);
    }
}
