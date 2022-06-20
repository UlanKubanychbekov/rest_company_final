package com.example.rest_company.repository;

import com.example.rest_company.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
//    Role findRoleName (String roleName);
}
