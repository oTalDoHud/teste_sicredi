package teste.hudson.model.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import teste.hudson.service.exception.ObjetoNaoEncontradoException;
import teste.hudson.service.utils.ExceptionUtils;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ObjetoNaoEncontradoException> objetoNaoEncontrado(ObjetoNaoEncontradoException e) {
        return ExceptionUtils.getResponseError(e.getClass().getName(), HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
