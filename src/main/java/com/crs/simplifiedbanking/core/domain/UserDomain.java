package com.crs.simplifiedbanking.core.domain;

import com.crs.simplifiedbanking.data.mongo.entity.UserBankEntity;
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

    public static UserDomain from(UserBankEntity entity){
        return UserDomain.builder()
                .id(entity.getId())
                .document(entity.getDocument())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .build();
    }
}
