package com.crs.simplifiedbanking.entrypoint.dto.out;

import com.crs.simplifiedbanking.core.domain.TypeUserEnum;
import com.crs.simplifiedbanking.core.domain.UserDomain;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record UserResponseDto
        (
                String id,
                String name,
                String email,
                String document,
                TypeUserEnum type,
                @JsonProperty("create_at")
                LocalDateTime createAt,
                @JsonProperty("update_at")
                LocalDateTime updateAt
         ) {

    public static UserResponseDto from(UserDomain domain){
        return  new UserResponseDto(
                domain.getId(),
                domain.getName(),
                domain.getEmail(),
                domain.getDocument(),
                domain.getType(),
                domain.getCreateAt(),
                domain.getUpdateAt()
                );
    }
}
