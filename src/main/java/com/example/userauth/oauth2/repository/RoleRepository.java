package com.example.userauth.oauth2.repository;

import com.example.userauth.oauth2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
