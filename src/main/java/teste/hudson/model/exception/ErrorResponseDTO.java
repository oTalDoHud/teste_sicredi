package teste.hudson.model.exception;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
public class ErrorResponseDTO implements Serializable {

    private String exceptionType;
    private int code;
    private String messages;
}
