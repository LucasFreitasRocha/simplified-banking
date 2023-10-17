package com.crs.simplifiedbanking.core.validate.user;

import com.crs.simplifiedbanking.core.domain.UserDomain;
import com.crs.simplifiedbanking.core.exception.CodeExceptionEnum;
import com.crs.simplifiedbanking.core.exception.CustomException;
import com.crs.simplifiedbanking.core.exception.ErrorInformation;
import com.crs.simplifiedbanking.core.validate.user.UserValidation;
import com.crs.simplifiedbanking.data.UserGatewayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.crs.simplifiedbanking.core.exception.CodeExceptionEnum.CREATION_OR_UPDATE_UNAVAILABLE;

@RequiredArgsConstructor
@Component
public class UserValidationImp implements UserValidation {
    private final UserGatewayRepository gatewayRepository;
    @Override
    public void create(UserDomain domain) {
        List<ErrorInformation> errors = new ArrayList<>();
        Optional<UserDomain> optionalEmail = gatewayRepository.findByEmail(domain.getEmail());
        Optional<UserDomain> optionalDocument = gatewayRepository.findByEmail(domain.getEmail());
        if(optionalEmail.isPresent()) addError(CREATION_OR_UPDATE_UNAVAILABLE,"email", errors);
        if(optionalDocument.isPresent()) addError(CREATION_OR_UPDATE_UNAVAILABLE, "document", errors);
        if(!errors.isEmpty()){
            throw  new CustomException("create fail", HttpStatus.BAD_REQUEST, errors);
        }
    }

    private void addError(CodeExceptionEnum code, String resource, List<ErrorInformation> errors) {
        errors.add(
                new ErrorInformation(
                        code.code,
                        code.message.formatted(resource)
                ));
    }


}
