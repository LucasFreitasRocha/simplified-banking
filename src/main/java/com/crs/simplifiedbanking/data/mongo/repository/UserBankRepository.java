package com.crs.simplifiedbanking.data.mongo.repository;

import com.crs.simplifiedbanking.data.mongo.entity.UserBankEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserBankRepository  extends MongoRepository<UserBankEntity, String> {


    Optional<UserBankEntity> findByEmail(String email);

    Optional<UserBankEntity> findByDocument(String Document);
}
