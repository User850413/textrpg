package com.game.textrpg.infrastructure.hero;

import java.util.List;

import com.game.textrpg.domains.hero.HeroCommand;
import com.game.textrpg.domains.hero.HeroInfo;
import com.game.textrpg.domains.place.PlaceInfo;

import jakarta.transaction.Transactional;

public interface HeroService {
    
    List<HeroInfo> findByUser(String userId);

    HeroInfo createHero(HeroCommand command, String userId);

    @Transactional
    void deleteHero(String heroId, String userId);

    HeroInfo getHeroDetail(String heroId);

    PlaceInfo moveHero(String userId, String heroId, String placeId);
}
