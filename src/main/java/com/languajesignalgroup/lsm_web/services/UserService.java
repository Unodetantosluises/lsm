package com.languajesignalgroup.lsm_web.services;

import com.languajesignalgroup.lsm_web.dto.RegistrationDto;
import com.languajesignalgroup.lsm_web.models.Users;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    Users findByEmail(String emailUser);

    Users findByUsername(String userName);
}
