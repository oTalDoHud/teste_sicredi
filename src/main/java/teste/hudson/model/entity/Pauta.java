package teste.hudson.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pauta")
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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "GMT-3")
    private LocalDateTime dataCriacao;

    public Pauta(String assuntoPauta, String dsPauta, LocalDateTime dataCriacao) {
        this.assuntoPauta = assuntoPauta;
        this.dsPauta = dsPauta;
        this.dataCriacao = dataCriacao;
    }
}
