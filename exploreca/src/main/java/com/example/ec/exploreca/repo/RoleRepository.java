package com.example.ec.exploreca.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ec.exploreca.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);
}
