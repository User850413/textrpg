package com.game.textrpg.infrastructure.heroItem;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.textrpg.domains.hero_item.HeroItem;
import com.game.textrpg.domains.hero_item.HeroItemId;

public interface HeroItemRepository extends JpaRepository<HeroItem, HeroItemId>{   
    List<HeroItem> findByHero_IdAndCountGreaterThan(UUID heroId, Integer count);
}
