package com.crs.simplifiedbanking.core.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CodeExceptionEnum {

    CREATION_OR_UPDATE_UNAVAILABLE("invalid.create.or.update", "the handling of this resource is currently unavailable. Because the %s already exist"),
    NOT_FOUND("notfound.resource", "this %s not found"),
    DELETE_UNAVAILABLE("invalid.delete", "the delete of this %s is currently unavailabe.");

    public final String code;
    public final String message;

}