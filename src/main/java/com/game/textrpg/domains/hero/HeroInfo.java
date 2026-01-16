package com.game.textrpg.domains.hero;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.user.User;
import com.game.textrpg.interfaces.web.hero.HeroResponseDto;
import com.game.textrpg.interfaces.web.hero.HeroDto.HeroResponse;

import lombok.Getter;

@Getter
public class HeroInfo {
    private final String name;
    private final String id;
    private final Place place;
    private final Backpack backpack;
    private final Integer level;
    private final Integer exp;

    public HeroInfo(Hero hero) {
        this.name = hero.getName();
        this.id = hero.getId().toString();
        this.backpack = hero.getBackpack();
        this.place = hero.getLocation();
        this.level = hero.getLevel();
        this.exp = hero.getExp();
    }

    public HeroResponseDto toHeroResponseDto() {
        return HeroResponseDto.builder()
                .id(id)
                .name(name)
                .locationName(place.getName())
                .locationId(place.getPlaceId().toString())
                .backpackName(backpack.getName())
                .backpackMax(backpack.getMaxCarriage())
                .level(level)
                .exp(exp)
                .build();

    }
}
