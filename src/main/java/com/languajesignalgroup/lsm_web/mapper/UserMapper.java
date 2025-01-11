package com.languajesignalgroup.lsm_web.mapper;

import com.languajesignalgroup.lsm_web.dto.UserDto;
import com.languajesignalgroup.lsm_web.models.Users;

import java.time.LocalDate;

public class UserMapper {
    public static Users mapToUser(UserDto user) {
        Users userDto = Users.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userLastName(user.getUserLastName())
                .emailUser(user.getEmailUser())
                .birthdateUser(LocalDate.from(user.getBirthdateUser()))
                .userPhotoUrl(user.getUserPhotoUrl())
                .active(user.getActive())
                .registrationDate(user.getRegistrationDate())
                .updatedOn(user.getUpdatedOn())
                .build();
        return userDto;
    }

    public static Users mapToUserDto(Users user){
        Users userDto = Users.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userLastName(user.getUserLastName())
                .emailUser(user.getEmailUser())
                .birthdateUser(user.getBirthdateUser())
                .userPhotoUrl(user.getUserPhotoUrl())
                .active(user.getActive())
                .registrationDate(user.getRegistrationDate())
                .updatedOn(user.getUpdatedOn())
                .build();
        return userDto;
    }
}
