package com.crs.simplifiedbanking.core.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class CustomError {

    private UUID id;
    private List<ErrorInformation> errors;
    private String path;
    private LocalDateTime date;
}
