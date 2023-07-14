package teste.hudson.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teste.hudson.model.dto.StatusSessaoDTO;
import teste.hudson.model.enums.FuncionamentoSessao;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessaoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer totalVotosSim;

    private Integer totalVotosNao;

    private Integer funcionamentoSessao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
    private LocalDateTime inicioSessao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
    private LocalDateTime finalSessao;

    private Pauta pauta;

    private List<Usuario> usuarios = new ArrayList<>();

    private StatusSessaoDTO statusSessaoDTO;

    public SessaoDTO(Sessao sessao) {
        this.id = sessao.getId();
        this.totalVotosSim = sessao.getTotalVotosSim();
        this.totalVotosNao = sessao.getTotalVotosNao();
        this.funcionamentoSessao = sessao.getFuncionamentoSessao().getCod();
        this.inicioSessao = sessao.getInicioSessao();
        this.finalSessao = sessao.getFinalSessao();
        this.pauta = sessao.getPauta();
        this.statusSessaoDTO = new StatusSessaoDTO((totalVotosNao + totalVotosSim), totalVotosSim, totalVotosNao, gerarStatusSessao());
        this.usuarios = sessao.getUsuarios();
    }

    private String gerarStatusSessao() {

        if (LocalDateTime.now().isAfter(finalSessao)) {
            return "A sessão já foi encerrada";
        }

        return "Sessão ainda aberta";
    }

}
