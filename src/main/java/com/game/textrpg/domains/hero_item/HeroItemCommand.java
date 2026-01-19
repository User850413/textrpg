package com.game.textrpg.domains.hero_item;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HeroItemCommand {
    private final String heroId;
    private final String itemId;
    private final Integer count;
}
