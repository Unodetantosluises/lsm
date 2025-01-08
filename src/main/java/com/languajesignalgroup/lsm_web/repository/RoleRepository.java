package com.languajesignalgroup.lsm_web.repository;

import com.languajesignalgroup.lsm_web.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String rolName);
}
