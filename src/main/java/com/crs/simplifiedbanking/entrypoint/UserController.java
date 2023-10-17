package com.crs.simplifiedbanking.entrypoint;

import com.crs.simplifiedbanking.entrypoint.dto.in.UserRequestDto;
import com.crs.simplifiedbanking.entrypoint.dto.out.UserResponseDto;
import com.crs.simplifiedbanking.entrypoint.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi{

    private final UserService service;
    @Override
    public ResponseEntity<UserResponseDto> create(UserRequestDto userRequestDto) {
        UserResponseDto dto = service.create(userRequestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
