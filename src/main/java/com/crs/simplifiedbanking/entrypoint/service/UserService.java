package com.crs.simplifiedbanking.entrypoint.service;

import com.crs.simplifiedbanking.core.domain.UserDomain;
import com.crs.simplifiedbanking.core.usecase.user.UserUseCase;
import com.crs.simplifiedbanking.entrypoint.dto.in.UserRequestDto;
import com.crs.simplifiedbanking.entrypoint.dto.out.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserUseCase useCase;
    public UserResponseDto create(UserRequestDto userRequestDto) {
        return UserResponseDto.from(useCase.create(UserDomain.from(userRequestDto)));
    }
}
