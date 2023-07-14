package teste.hudson.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teste.hudson.model.enums.FuncionamentoSessao;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_votos_sim")
    private Integer totalVotosSim;

    @Column(name = "total_votos_nao")
    private Integer totalVotosNao;

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

    @ManyToMany
    @JoinTable(
            name = "sessao_usuario",
            joinColumns = @JoinColumn(name = "id_sessao"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> usuarios = new ArrayList<>();

    public Sessao(Long id, Integer totalVotosSim, Integer totalVotosNao, FuncionamentoSessao funcionamentoSessao, LocalDateTime inicioSessao, LocalDateTime finalSessao, Pauta pauta) {
        this.id = id;
        this.totalVotosSim = totalVotosSim;
        this.totalVotosNao = totalVotosNao;
        this.funcionamentoSessao = funcionamentoSessao.getCod();
        this.inicioSessao = inicioSessao;
        this.finalSessao = finalSessao;
        this.pauta = pauta;
    }

    public Sessao(Integer totalVotosSim, Integer totalVotosNao, FuncionamentoSessao funcionamentoSessao, LocalDateTime inicioSessao, LocalDateTime finalSessao, Pauta pauta) {
        this.totalVotosSim = totalVotosSim;
        this.totalVotosNao = totalVotosNao;
        this.funcionamentoSessao = funcionamentoSessao.getCod();
        this.inicioSessao = inicioSessao;
        this.finalSessao = finalSessao;
        this.pauta = pauta;
    }

    public FuncionamentoSessao getFuncionamentoSessao() {
        return FuncionamentoSessao.toEnum(funcionamentoSessao);
    }

    public void setFuncionamentoSessao(FuncionamentoSessao funcionamentoSessao) {
        this.funcionamentoSessao = funcionamentoSessao.getCod();
    }

    public void addVotoSim() {
        totalVotosSim++;
    }

    public void addVotoNao() {
        totalVotosNao++;
    }
}
