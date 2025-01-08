package com.languajesignalgroup.lsm_web.services;

import com.languajesignalgroup.lsm_web.dto.RegistrationDto;
import com.languajesignalgroup.lsm_web.models.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String emailUser);

    User findByUsername(String userName);
}
