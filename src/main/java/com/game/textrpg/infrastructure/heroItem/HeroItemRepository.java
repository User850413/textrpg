package com.game.textrpg.infrastructure.heroItem;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.textrpg.domains.hero_item.HeroItem;

public interface HeroItemRepository extends JpaRepository<HeroItem, UUID>{   
    List<HeroItem> findByHero_Id(UUID heroId);
}
