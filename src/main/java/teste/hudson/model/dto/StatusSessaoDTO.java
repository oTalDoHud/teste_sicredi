package teste.hudson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusSessaoDTO {
    private Integer totalVotos;
    private Integer totalVotosSim;
    private Integer totalVotosNao;
    private String status;
}
