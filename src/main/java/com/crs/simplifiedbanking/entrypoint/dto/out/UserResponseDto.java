package com.crs.simplifiedbanking.entrypoint.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record UserResponseDto
        (
                String id,
                String name,
                String email,
                String document,
                @JsonProperty("create_at")
                LocalDateTime createAt,
                @JsonProperty("update_at")
                LocalDateTime updateAt
         ) {
}
