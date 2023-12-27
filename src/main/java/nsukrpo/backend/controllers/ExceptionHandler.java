package nsukrpo.backend.controllers;

import jakarta.validation.ValidationException;
import nsukrpo.backend.model.dtos.ExceptionDto;
import nsukrpo.backend.model.exceptions.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@CrossOrigin(maxAge = 3000)
public class ExceptionHandler extends ResponseEntityExceptionHandler {
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
//        return new ResponseEntity<>(ExceptionDto.builder().code(400).message("Validation Failed").build(),HttpStatus.BAD_REQUEST);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
//        return new ResponseEntity<>(ExceptionDto.builder().code(400).message("Validation Failed").build(),HttpStatus.BAD_REQUEST);
//    }

    @org.springframework.web.bind.annotation.ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception e){
        return new ResponseEntity<>(ExceptionDto.builder().code(400).message(e.getMessage()).build(),HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({ValidationException.class})
    protected ResponseEntity<Object> handleValidationException(Exception e){
        return new ResponseEntity<>(ExceptionDto.builder().code(400).message(e.getMessage()).build(),HttpStatus.BAD_REQUEST);
    }

}
