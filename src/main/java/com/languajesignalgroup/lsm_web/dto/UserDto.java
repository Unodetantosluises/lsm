package com.languajesignalgroup.lsm_web.dto;

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

    private String userName;

    private String userLastName;

    private String emailUser;

    private LocalDateTime birthdateUser;

    private String userPhotoUrl;

    private Boolean active = true;

    private LocalDateTime registrationDate;

    private LocalDateTime updatedOn;
}
