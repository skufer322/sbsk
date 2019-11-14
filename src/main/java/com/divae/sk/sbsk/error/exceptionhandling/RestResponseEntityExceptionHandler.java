package com.divae.sk.sbsk.error.exceptionhandling;

import com.divae.sk.sbsk.author.AuthorNotFoundException;
import com.divae.sk.sbsk.book.restapi.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AuthorNotFoundException.class, BookNotFoundException.class})
    protected ResponseEntity<Object> entityNotFound(RuntimeException ex, WebRequest request){
        String bodyOfResponse = "The object you requested could not be found: " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
