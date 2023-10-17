package com.crs.simplifiedbanking.data.mongo.repository;

import com.crs.simplifiedbanking.data.mongo.entity.UserBankEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBankRepository  extends MongoRepository<UserBankEntity, String> {
}
