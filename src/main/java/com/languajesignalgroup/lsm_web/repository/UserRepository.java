package com.languajesignalgroup.lsm_web.repository;

import com.languajesignalgroup.lsm_web.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);

    Users findByEmailUser(String emailUser);
}
