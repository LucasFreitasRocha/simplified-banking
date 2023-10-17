package com.crs.simplifiedbanking.data.mongo.repository;

import com.crs.simplifiedbanking.data.mongo.entity.AccountBank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBankRepository extends MongoRepository<AccountBank, String> {
}
