package com.crs.simplifiedbanking.core.usecase.user;

import com.crs.simplifiedbanking.core.domain.UserDomain;
import com.crs.simplifiedbanking.core.validate.user.UserValidation;
import com.crs.simplifiedbanking.data.UserGatewayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserUseCaseImp implements UserUseCase {

    private final UserValidation validation;
    private final UserGatewayRepository gatewayRepository;
    private final PasswordEncoder passwordEncoder;
    private final Clock clock;

    @Override
    public UserDomain create(UserDomain domain) {
        validation.create(domain);
        domain.setPassword(passwordEncoder.encode(domain.getPassword()));
        LocalDateTime date = LocalDateTime.now(clock);
        domain.setCreateAt(date);
        domain.setUpdateAt(date);
        return gatewayRepository.save(domain);
    }
}
