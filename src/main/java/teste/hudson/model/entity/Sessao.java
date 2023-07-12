package teste.hudson.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import teste.hudson.model.enums.FuncionamentoSessao;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_votos")
    private Integer totalVotos;

    @Column(name = "funcionamento_sessao")
    private Integer funcionamentoSessao;

    @Column(name = "inicio_sessao", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "GMT-3")
    private LocalDateTime inicioSessao;

    @Column(name = "final_sessao")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "GMT-3")
    private LocalDateTime finalSessao;

    @OneToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    public Sessao(Pauta pauta, Integer totalVotos, FuncionamentoSessao funcionamentoSessao, LocalDateTime inicioSessao, LocalDateTime finalSessao) {
        this.pauta = pauta;
        this.totalVotos = totalVotos;
        this.funcionamentoSessao = funcionamentoSessao.getCod();
        this.inicioSessao = inicioSessao;
        this.finalSessao = finalSessao;
    }

    public Sessao(Long id, Pauta pauta, Integer totalVotos, FuncionamentoSessao funcionamentoSessao, LocalDateTime inicioSessao, LocalDateTime finalSessao) {
        this.id = id;
        this.pauta = pauta;
        this.totalVotos = totalVotos;
        this.funcionamentoSessao = funcionamentoSessao.getCod();
        this.inicioSessao = inicioSessao;
        this.finalSessao = finalSessao;
    }

    public FuncionamentoSessao getFuncionamentoPauta() {
        return FuncionamentoSessao.toEnum(funcionamentoSessao);
    }

    public void setFuncionamentoPauta(FuncionamentoSessao funcionamentoSessao) {
        this.funcionamentoSessao = funcionamentoSessao.getCod();
    }
}
