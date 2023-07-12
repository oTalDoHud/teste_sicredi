package teste.hudson.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePautaDTO {

    @JsonProperty("assunto_pauta")
    private String assuntoPauta;

    @JsonProperty("ds_pauta")
    private String dsPauta;
}
