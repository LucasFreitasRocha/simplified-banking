package com.crs.simplifiedbanking.core.domain;

import com.crs.simplifiedbanking.data.mongo.entity.UserBankEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Data
@Builder
public class AccountDomain {
    private String id;
    private String accountNumber;
    private String agencyNumber;
    private BigDecimal amount;
    private UserDomain user;
}
