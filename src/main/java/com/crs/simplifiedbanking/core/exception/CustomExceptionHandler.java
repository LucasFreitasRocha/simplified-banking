package com.crs.simplifiedbanking.core.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<CustomError> handleCustomException(CustomException ex, HttpServletRequest request) {
        return ResponseEntity.status(ex.getStatus()).body(CustomError.builder()
                .path(request.getRequestURI())
                .id(UUID.randomUUID())
                .date(LocalDateTime.now())
                .errors(ex.getErrorInformations())
                .build());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CustomError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<ErrorInformation> errorInformation = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errorInformation.add(new ErrorInformation(error.getCode(), error.getDefaultMessage()));
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CustomError.builder()
                .errors(errorInformation)
                .id(UUID.randomUUID())
                .date(LocalDateTime.now())
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<CustomError> handleJsonParseException(Exception ex, HttpServletRequest request) {
        List<ErrorInformation> errorInformation = new ArrayList<>();
        errorInformation.add(new ErrorInformation("json.parse", ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                CustomError.builder()
                        .errors(errorInformation)
                        .id(UUID.randomUUID())
                        .date(LocalDateTime.now())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CustomError> handleGenericException(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        List<ErrorInformation> errorInformation = new ArrayList<>();
        errorInformation.add(new ErrorInformation("INTERNAL_SERVER_ERROR", ex.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                CustomError.builder()
                        .errors(errorInformation)
                        .id(UUID.randomUUID())
                        .date(LocalDateTime.now())
                        .path(request.getRequestURI())
                        .build()
        );
    }
}