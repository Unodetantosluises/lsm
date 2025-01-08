package com.languajesignalgroup.lsm_web.repository;

import com.languajesignalgroup.lsm_web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);

    User findByEmail(String emailUser);
}
