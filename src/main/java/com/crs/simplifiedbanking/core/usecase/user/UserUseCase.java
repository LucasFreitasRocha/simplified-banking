package com.crs.simplifiedbanking.core.usecase.user;

import com.crs.simplifiedbanking.core.domain.UserDomain;

public interface UserUseCase {
    UserDomain create(UserDomain domain);
}
