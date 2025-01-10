package com.languajesignalgroup.lsm_web.repository;

import com.languajesignalgroup.lsm_web.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String userName);

    Users findByEmail(String emailUser);

    Users findFirstByUsername(String userName);
}
