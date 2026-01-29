package com.game.textrpg.domains.skill;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, UUID>{
    
}
