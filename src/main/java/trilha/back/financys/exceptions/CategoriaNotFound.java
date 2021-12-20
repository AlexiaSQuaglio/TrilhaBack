package trilha.back.financys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoriaNotFound extends RuntimeException{
    public CategoriaNotFound (String message){
        super(message);
    }
}
