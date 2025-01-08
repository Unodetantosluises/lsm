package com.languajesignalgroup.lsm_web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationDto {
    private Long userId;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String userLastName;

    @NotEmpty
    private LocalDateTime birthdateUser;

    @NotEmpty
    private String emailUser;

    @NotEmpty
    private String password;
}
