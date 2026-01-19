package com.game.textrpg.domains.hero_item;

import com.game.textrpg.interfaces.web.hero_item.HeroItemResponseDto;

import lombok.Getter;

@Getter
public class HeroItemInfo {
    private final String itemName;
    private final Integer itemCount;
    private final String description;

    public HeroItemInfo(String name, Integer itemCount, String description){
        this.itemName = name;
        this.itemCount = itemCount;
        this.description = description;
    }

    public HeroItemResponseDto toResponseDto() {
        return HeroItemResponseDto.builder()
                .itemName(itemName)
                .itemCount(itemCount)
                .description(description)
                .build();
    }
}
