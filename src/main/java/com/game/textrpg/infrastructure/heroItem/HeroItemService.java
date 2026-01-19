package com.game.textrpg.infrastructure.heroItem;

import java.util.List;

import com.game.textrpg.domains.hero_item.HeroItemCommand;
import com.game.textrpg.domains.hero_item.HeroItemInfo;

public interface HeroItemService {
    List<HeroItemInfo> findByHero(String heroId);
    HeroItemInfo addHeroItem(HeroItemCommand heroItemCommand);
}
