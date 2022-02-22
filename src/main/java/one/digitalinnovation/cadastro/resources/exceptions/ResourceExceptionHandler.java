package one.digitalinnovation.cadastro.resources.exceptions;

import one.digitalinnovation.cadastro.services.exceptions.EntityAlreadyExistsException;
import one.digitalinnovation.cadastro.services.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(Instant.now(),HttpStatus.NOT_FOUND.value(), "Resource not Found", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<StandardError> entityAlreadyExistsException(EntityAlreadyExistsException e, HttpServletRequest request){
        StandardError err = new StandardError(Instant.now(),HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
