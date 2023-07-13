package teste.hudson.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teste.hudson.model.entity.Pauta;
import teste.hudson.model.entity.Sessao;
import teste.hudson.model.entity.Usuario;
import teste.hudson.model.enums.FuncionamentoSessao;
import teste.hudson.repository.PautaRepository;
import teste.hudson.repository.SessaoRepository;
import teste.hudson.repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBservice {

    private final LocalDateTime date = LocalDateTime.now();
    @Autowired
    private PautaRepository pautaRepository;
    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void instanciandoBancoDeDados() {
        sessaoRepository.deleteAll();
        pautaRepository.deleteAll();
        usuarioRepository.deleteAll();

        Pauta pauta01 = new Pauta("Teste assunto pautas 1", "Descrição 01", date);
        Pauta pauta02 = new Pauta("Teste assunto pautas 2", "Descrição 02", date);
        Pauta pauta03 = new Pauta("Teste assunto pautas 3", "Descrição 03", date);

        pautaRepository.saveAll(Arrays.asList(pauta01, pauta02, pauta03));

        Sessao sessao01 = new Sessao(pauta01, 45, FuncionamentoSessao.ATIVA, date, date.plusMinutes(1));
        Sessao sessao02 = new Sessao(pauta02, 54, FuncionamentoSessao.ATIVA, date, date.plusMinutes(30));
        Sessao sessao03 = new Sessao(pauta03, 98, FuncionamentoSessao.ATIVA, date, date.plusMinutes(90));

        sessaoRepository.saveAll(Arrays.asList(sessao01, sessao02, sessao03));

        Usuario usuario1 = new Usuario("User01", "62800772093");
        Usuario usuario2 = new Usuario("User01", "40195067010");
        Usuario usuario3 = new Usuario("User01", "45864759007");

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));
    }
}