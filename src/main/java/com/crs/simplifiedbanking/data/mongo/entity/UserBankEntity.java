package com.crs.simplifiedbanking.data.mongo.entity;

import com.crs.simplifiedbanking.core.domain.UserDomain;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "user_bank")
@Builder
@Data
public class UserBankEntity {

    @Id
    private String id;
    private String name;
    @Indexed(unique=true)
    private String document;
    @Indexed(unique=true)
    private String email;
    private String password;
    @Field(value = "create_at")
    private LocalDateTime createAt;
    @Field(value = "update_at")
    private LocalDateTime updateAt;


    public static UserBankEntity from(UserDomain domain){
        return UserBankEntity.builder()
                .id(domain.getId())
                .document(domain.getDocument())
                .name(domain.getName())
                .email(domain.getEmail())
                .password(domain.getPassword())
                .createAt(domain.getCreateAt())
                .updateAt(domain.getUpdateAt())
                .build();
    }

}
