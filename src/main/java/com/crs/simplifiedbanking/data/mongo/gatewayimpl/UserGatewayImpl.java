package com.crs.simplifiedbanking.data.mongo.gatewayimpl;

import com.crs.simplifiedbanking.core.domain.UserDomain;
import com.crs.simplifiedbanking.data.UserGatewayRepository;
import com.crs.simplifiedbanking.data.mongo.entity.UserBankEntity;
import com.crs.simplifiedbanking.data.mongo.repository.UserBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGatewayRepository {
    private final UserBankRepository repository;

    @Override
    public UserDomain save(UserDomain domain) {
        return UserDomain.from(repository.save(UserBankEntity.from(domain)));
    }

    @Override
    public Optional<UserDomain> findByEmail(String email) {
        Optional<UserBankEntity> optional = repository.findByEmail(email);
        return optional.isEmpty() ? Optional.empty() : Optional.of(UserDomain.from(optional.get()));
    }

    @Override
    public Optional<UserDomain> findByDocument(String document) {
        Optional<UserBankEntity> optional = repository.findByEmail(document);
        return optional.isEmpty() ? Optional.empty() : Optional.of(UserDomain.from(optional.get()));
    }
}
