package teste.hudson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotoDTO {

    private Long sessao;

    private String cpf;

    private Integer voto;
}
