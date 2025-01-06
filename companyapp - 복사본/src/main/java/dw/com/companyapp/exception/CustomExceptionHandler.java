package dw.com.companyapp.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(dw.com.companyapp.exception.InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(
            dw.com.companyapp.exception.InvalidRequestException e) {
        return new ResponseEntity<>(
                e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(dw.com.companyapp.exception.ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(
            dw.com.companyapp.exception.ResourceNotFoundException e) {
        return new ResponseEntity<>(
                e.getMessage(), HttpStatus.NOT_FOUND);
    }
}








