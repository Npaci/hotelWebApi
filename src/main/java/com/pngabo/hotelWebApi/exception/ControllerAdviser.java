package com.pngabo.hotelWebApi.exception;

import com.pngabo.hotelWebApi.model.DTO.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerAdviser {

//    @ExceptionHandler(ElementNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorDTO handle(ElementNotFoundException ex) {
//        return new ErrorDTO(ex.getMessage());
//    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handle(ElementNotFoundException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Expires", Instant.now().plusMillis(600000).toString());
        return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(new ErrorDTO(ex.getMessage()));
        // ou return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), headers, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ElementAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handle(ElementAlreadyExistException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Expires", Instant.now().plusMillis(600000).toString());
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(new ErrorDTO(ex.getMessage()));
        // ou return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), headers, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handle(MethodArgumentNotValidException ex) {
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(ex.getMessage()));
        // ou return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), headers, HttpStatus.NOT_FOUND);
    }

}
