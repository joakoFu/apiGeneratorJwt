package cl.nttdata.generatorjwt.apiGeneratorJwt.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.annotation.Priority;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import org.slf4j.Logger;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@ControllerAdvice
@Priority(HIGHEST_PRECEDENCE)
public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<Object> handlerDefaultHandler(JWTVerificationException ex) {
        logger.error(ex.getMessage());
        HashMap<String, String> result = new HashMap<>();
        result.put("err", "Token invalid");
        return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerDefaultHandler(Exception ex) {
        logger.error(ex.getMessage());
        HashMap<String, String> result = new HashMap<>();
        result.put("err", "Token invalid");
        return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }
}
