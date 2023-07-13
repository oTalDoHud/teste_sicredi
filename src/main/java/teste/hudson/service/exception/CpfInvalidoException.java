package teste.hudson.service.exception;

public class CpfInvalidoException extends RuntimeException{

    public CpfInvalidoException(String menssagem) {
        super(menssagem);
    }

}
