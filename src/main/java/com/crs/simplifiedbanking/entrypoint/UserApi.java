package com.crs.simplifiedbanking.entrypoint;

import com.crs.simplifiedbanking.entrypoint.dto.in.UserRequestDto;
import com.crs.simplifiedbanking.entrypoint.dto.out.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/v1")
@Tag(name = "user")
public interface UserApi {


    @Operation(summary = "create user")
    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserRequestDto userRequestDto);
}
