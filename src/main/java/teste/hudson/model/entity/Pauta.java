package teste.hudson.model.entity;

import jakarta.persistence.*;
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
public class Pauta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assunto_pauta", nullable = false)
    private String assuntoPauta;

    @Column(name = "ds_pauta")
    private String dsPauta;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    public Pauta(String assuntoPauta, String dsPauta, LocalDateTime dataCriacao) {
        this.assuntoPauta = assuntoPauta;
        this.dsPauta = dsPauta;
        this.dataCriacao = dataCriacao;
    }
}
