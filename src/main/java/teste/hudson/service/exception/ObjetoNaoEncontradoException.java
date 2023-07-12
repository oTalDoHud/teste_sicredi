package teste.hudson.service.exception;

public class ObjetoNaoEncontradoException extends RuntimeException{

    public ObjetoNaoEncontradoException(String menssagem) {
        super(menssagem);
    }

}
