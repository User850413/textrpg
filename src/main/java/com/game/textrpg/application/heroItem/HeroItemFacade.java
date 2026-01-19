package com.game.textrpg.application.heroItem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.hero_item.HeroItemInfo;
import com.game.textrpg.infrastructure.heroItem.HeroItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroItemFacade {

    private final HeroItemService heroItemService;

    public List<HeroItemInfo> findByHero(String heroId) {
        if(heroId == null){
            throw new NullPointerException();
        }

        List<HeroItemInfo> items = heroItemService.findByHero(heroId);
        return items;
    }
}
