package com.game.textrpg.infrastructure.action;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.textrpg.domains.action.Action;


public interface ActionRepository extends JpaRepository<Action, UUID>{
    
}
