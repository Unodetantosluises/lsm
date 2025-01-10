package com.languajesignalgroup.lsm_web.mapper;

import com.languajesignalgroup.lsm_web.dto.UserDto;
import com.languajesignalgroup.lsm_web.models.User;

import java.time.LocalDate;

public class UserMapper {
    public static User mapToUser(UserDto user) {
        User userDto = User.builder()
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

    public static User mapToUserDto(User user){
        User userDto = User.builder()
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
