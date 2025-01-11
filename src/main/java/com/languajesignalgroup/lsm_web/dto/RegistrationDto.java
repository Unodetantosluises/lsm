package com.languajesignalgroup.lsm_web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Long userId;

    @NotNull(message = "User name cannot be null.")
    private String userName;

    @NotNull(message = "User last name cannot be null.")
    private String userLastName;

    @NotNull(message = "Birthdate cannot be null.")
    private LocalDate birthdateUser;

    @NotNull
    @Email(message = "Should be a validate email.")
    private String emailUser;

    @NotNull
    @Size(min = 8, message = "Password should be at least 8 digits.")
    private String password;
}
