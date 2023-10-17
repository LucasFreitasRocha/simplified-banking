package com.crs.simplifiedbanking.data.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Document(collection = "account_bank")
@Data
public class AccountBank {


    @Transient
    public static final String SEQUENCE_NAME = "account_sequence";
    @Id
    private String id;

    @Field(value = "account_number")
    private String accountNumber;
    @Field(value = "agency_number")
    private String agencyNumber;
    @Field(targetType = DECIMAL128)
    private BigDecimal amount;
    @DBRef
    private UserBankEntity user;

}
