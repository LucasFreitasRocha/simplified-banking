package com.crs.simplifiedbanking.core.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor

public class CustomException extends RuntimeException {


    private final HttpStatus status;
    private final List<ErrorInformation> errorInformations;

    public CustomException(String message, HttpStatus status, List<ErrorInformation> errorInformations) {
        super(message);
        this.status = status;
        this.errorInformations = errorInformations;
    }

}