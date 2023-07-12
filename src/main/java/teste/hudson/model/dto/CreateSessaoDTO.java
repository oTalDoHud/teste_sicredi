package teste.hudson.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSessaoDTO {

    @JsonProperty("pauta")
    private Long pauta;

    @JsonProperty("duracao_minutos")
    private Integer duracaoMinutos;
}
