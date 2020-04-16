package com.example.ec.exploreca.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ec.exploreca.domain.User;

/**
 * Created by Manpreet
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String userName);
}