package com.ducapas.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducapas.api.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,UUID>{
    User findByLogin(String login);
}
