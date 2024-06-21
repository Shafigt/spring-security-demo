package com.shafig.springsecuritydemo.repository;

import com.shafig.springsecuritydemo.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
