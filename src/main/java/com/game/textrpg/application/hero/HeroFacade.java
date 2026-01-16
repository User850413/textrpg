package com.game.textrpg.application.hero;

import java.util.List;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.hero.HeroInfo;
import com.game.textrpg.infrastructure.hero.HeroService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroFacade {

    private final HeroService heroService;

    public List<HeroInfo> findByUser(String userId) {
        List<HeroInfo> heroes = heroService.findByUser(userId);

        return heroes;
    }
    
}
