package com.game.textrpg.infrastructure.hero;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.textrpg.domains.hero.Hero;

public interface HeroRepository  extends JpaRepository<Hero, UUID>{
    List<Hero> findByUser_Id(UUID userId);
}
