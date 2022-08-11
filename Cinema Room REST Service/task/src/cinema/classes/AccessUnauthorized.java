package cinema.classes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class AccessUnauthorized extends RuntimeException {
    public AccessUnauthorized(String cause){
        super(cause);
    }
}