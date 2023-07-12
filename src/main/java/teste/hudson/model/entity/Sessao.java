package teste.hudson.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Sessao implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_votos")
    private Integer totalVotos;

    @Column(name = "inicio_sessao", nullable = false)
    private LocalDateTime inicioSessao;

    @Column(name = "final_sessao")
    private LocalDateTime finalSessao;
}
