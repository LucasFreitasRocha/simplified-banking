package com.crs.simplifiedbanking.data.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Document(collection = "transaction_bank")
public class TransactionBank {

    @Id
    private String id;

    private UserBankEntity payee;

    private UserBankEntity payer;

    @Field(value = "transaction_code")
    private UUID transactionCode;
    @Field(value = "create_at")
    private LocalDateTime createAt;
    @Field(targetType = DECIMAL128)
    private BigDecimal value;
}
