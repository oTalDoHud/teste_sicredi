package teste.hudson.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teste.hudson.model.entity.Pauta;
import teste.hudson.model.entity.Sessao;
import teste.hudson.repository.PautaRepository;
import teste.hudson.repository.SessaoRepository;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBservice {

    private final LocalDateTime date = LocalDateTime.now();
    @Autowired
    private PautaRepository pautaRepository;
    @Autowired
    private SessaoRepository sessaoRepository;

    public void instanciandoBancoDeDados() {
        Pauta pauta01 = new Pauta(1L, "Teste assunto pautas 1", "Descrição 01", date);
        Pauta pauta02 = new Pauta(2L, "Teste assunto pautas 2", "Descrição 02", date);
        Pauta pauta03 = new Pauta(3L, "Teste assunto pautas 3", "Descrição 03", date);

        pautaRepository.saveAll(Arrays.asList(pauta01, pauta02, pauta03));

        Sessao sessao01 = new Sessao(1L, 45, date, date);
        Sessao sessao02 = new Sessao(2L, 854, date, date);
        Sessao sessao03 = new Sessao(3L, 99, date, date);

        sessaoRepository.saveAll(Arrays.asList(sessao01, sessao02, sessao03));
    }
}