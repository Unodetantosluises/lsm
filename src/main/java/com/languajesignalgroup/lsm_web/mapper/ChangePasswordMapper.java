package com.languajesignalgroup.lsm_web.mapper;

import com.languajesignalgroup.lsm_web.dto.ChangePasswordDto;
import com.languajesignalgroup.lsm_web.models.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ChangePasswordMapper {
    public static Users mapToEntity(ChangePasswordDto changePasswordDto, Users user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Actualiza solo la contraseña
        user.setPassword(encoder.encode(changePasswordDto.getPassword()));
        return user;
    }
}
