package com.crs.simplifiedbanking.core.domain;

import com.crs.simplifiedbanking.data.mongo.entity.UserBankEntity;
import com.crs.simplifiedbanking.entrypoint.dto.in.UserRequestDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class UserDomain {
    private String id;
    private String name;
    private String document;
    private String email;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private TypeUserEnum type;

    public static UserDomain from(UserBankEntity entity){
        return UserDomain.builder()
                .id(entity.getId())
                .document(entity.getDocument())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .type(entity.getType())
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .build();
    }

    public static UserDomain from(UserRequestDto dto){
        return UserDomain.builder()
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .document(dto.document())
                .type(dto.type())
                .build();
    }
}
