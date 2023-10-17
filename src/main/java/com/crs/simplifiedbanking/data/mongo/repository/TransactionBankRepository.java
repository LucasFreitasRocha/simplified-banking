package com.crs.simplifiedbanking.data.mongo.repository;

import com.crs.simplifiedbanking.data.mongo.entity.TransactionBank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionBankRepository extends MongoRepository<TransactionBank, String> {
}
