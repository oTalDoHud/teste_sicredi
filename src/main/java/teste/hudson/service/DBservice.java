package teste.hudson.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teste.hudson.model.entity.Pauta;
import teste.hudson.model.entity.Sessao;
import teste.hudson.model.enums.FuncionamentoSessao;
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
        Pauta pauta01 = new Pauta("Teste assunto pautas 1", "Descrição 01", date);
        Pauta pauta02 = new Pauta("Teste assunto pautas 2", "Descrição 02", date);
        Pauta pauta03 = new Pauta("Teste assunto pautas 3", "Descrição 03", date);

        pautaRepository.saveAll(Arrays.asList(pauta01, pauta02, pauta03));

        Sessao sessao01 = new Sessao(pauta01, 45, FuncionamentoSessao.ATIVA, date, date.plusMinutes(1));
        Sessao sessao02 = new Sessao(pauta02, 54, FuncionamentoSessao.ATIVA, date, date.plusMinutes(30));
        Sessao sessao03 = new Sessao(pauta03, 98, FuncionamentoSessao.ATIVA, date, date.plusMinutes(90));

        sessaoRepository.saveAll(Arrays.asList(sessao01, sessao02, sessao03));
    }
}