package com.crs.simplifiedbanking.entrypoint.dto.in;

import com.crs.simplifiedbanking.core.domain.TypeUserEnum;

public record UserRequestDto(
        String name,
        String document,
        String email,
        String password,
        TypeUserEnum type
) {
}
