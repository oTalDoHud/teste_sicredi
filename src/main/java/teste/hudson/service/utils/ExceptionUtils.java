package teste.hudson.service.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import teste.hudson.model.exception.ErrorResponseDTO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

    public static ResponseEntity getResponseError(String name, Integer status, String message) {
        ErrorResponseDTO.ErrorResponseDTOBuilder errorResponseDTOBuilder =
                ErrorResponseDTO.builder()
                        .exceptionType(name)
                        .code(status);

        if (message != null) {
            errorResponseDTOBuilder.messages(message);
        }

        return ResponseEntity
                .status(status)
                .body(errorResponseDTOBuilder.build());
    }

}
