package com.languajesignalgroup.lsm_web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;

    @NotNull(message = "User name cannot be null.")
    private String userName;

    @NotNull(message = "User last name cannot be null.")
    private String userLastName;

    @NotNull(message = "Email user cannot be null.")
    private String emailUser;

    @NotNull(message = "Birthdate cannot be null.")
    private LocalDateTime birthdateUser;

    private String userPhotoUrl;

    private Boolean active = true;

    private LocalDateTime registrationDate;

    private LocalDateTime updatedOn;
}
