package com.crs.simplifiedbanking.data;

import com.crs.simplifiedbanking.core.domain.UserDomain;

public interface UserGatewayRepository {

     UserDomain save(UserDomain domain);
}
