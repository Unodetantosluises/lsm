package com.languajesignalgroup.lsm_web.services.impl;

import com.languajesignalgroup.lsm_web.dto.RegistrationDto;
import com.languajesignalgroup.lsm_web.models.Role;
import com.languajesignalgroup.lsm_web.models.User;
import com.languajesignalgroup.lsm_web.repository.RoleRepository;
import com.languajesignalgroup.lsm_web.repository.UserRepository;
import com.languajesignalgroup.lsm_web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setUserName(registrationDto.getUserName());
        user.setUserLastName(registrationDto.getUserLastName());
        user.setBirthdateUser(LocalDate.from(registrationDto.getBirthdateUser()));
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        Role role = roleRepository.findByName("STUDENT");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
}
