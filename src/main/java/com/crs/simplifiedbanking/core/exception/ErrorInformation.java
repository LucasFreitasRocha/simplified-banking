package com.crs.simplifiedbanking.core.exception;

public record ErrorInformation(
        String code,
        String message) {
}
