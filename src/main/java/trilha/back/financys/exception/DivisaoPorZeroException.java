package trilha.back.financys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DivisaoPorZeroException extends RuntimeException{

    public DivisaoPorZeroException(String exception){
        super(exception);
    }
}
