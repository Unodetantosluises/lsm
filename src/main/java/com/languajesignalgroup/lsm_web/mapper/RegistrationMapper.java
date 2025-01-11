package com.languajesignalgroup.lsm_web.mapper;

import com.languajesignalgroup.lsm_web.dto.RegistrationDto;
import com.languajesignalgroup.lsm_web.models.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

public class RegistrationMapper {
    public static Users mapToRegistration(RegistrationDto registration){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Users registrationDto = Users.builder()
                .userId(registration.getUserId())
                .userName(registration.getUserName())
                .userLastName(registration.getUserLastName())
                .birthdateUser(LocalDate.from(registration.getBirthdateUser()))
                .emailUser(registration.getEmailUser())
                .password(encoder.encode(registration.getPassword()))
                .build();
        return registrationDto;
    }

    public static RegistrationDto mapToDto(Users user) {
        return RegistrationDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userLastName(user.getUserLastName())
                .birthdateUser(user.getBirthdateUser())
                .emailUser(user.getEmailUser())
                .build();
    }
}
