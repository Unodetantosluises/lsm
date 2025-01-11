package com.languajesignalgroup.lsm_web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangePasswordDto {
    private Long userId;

    @NotNull
    @Size(min = 8, message = "Password should be at least 8 digits.")
    private String password;

    @NotNull
    @Size(min = 8, message = "Password should be at least 8 characters.")
    private String confirmPassword;
}
