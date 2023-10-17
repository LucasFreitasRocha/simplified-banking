package com.crs.simplifiedbanking.data;

import com.crs.simplifiedbanking.core.domain.UserDomain;

import java.util.Optional;

public interface UserGatewayRepository {

     UserDomain save(UserDomain domain);

     Optional<UserDomain> findByEmail(String email);

     Optional<UserDomain> findByDocument(String document);
}
