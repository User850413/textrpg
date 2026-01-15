package com.game.textrpg.infrastructure.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.textrpg.domains.user.User;


public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserId(String userId);
}
