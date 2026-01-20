package com.game.textrpg.domains.hero;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.place.Place;
import com.game.textrpg.interfaces.web.backpack.BackpackDto;
import com.game.textrpg.interfaces.web.hero.HeroResponseDto.GeneralHeroResponseDto;
import com.game.textrpg.interfaces.web.place.PlaceDto;

import lombok.Getter;

@Getter
public class HeroInfo {
    private final String name;
    private final String id;
    private final Place location;
    private final Backpack backpack;
    private final Integer level;
    private final Integer exp;
    private final Integer currentCarriage;

    public HeroInfo(Hero hero, Integer currentCarriage) {
        this.name = hero.getName();
        this.id = hero.getId().toString();
        this.backpack = hero.getBackpack();
        this.location = hero.getLocation();
        this.level = hero.getLevel();
        this.exp = hero.getExp();
        this.currentCarriage = currentCarriage;
    }

    public GeneralHeroResponseDto toGeneralHeroResponseDto() {
        return GeneralHeroResponseDto.builder()
                .id(id)
                .name(name)
                .location(
                    PlaceDto.PlaceResponse.builder()
                        .name(location.getName())
                        .id(location.getId().toString())
                        .placeId(location.getPlaceId())
                        .build()
                )
                .backpack(
                    BackpackDto.BackpackResponse.builder()
                        .name(backpack.getName())
                        .id(backpack.getId().toString())
                        .maxCarriage(backpack.getMaxCarriage())
                        .currentCarriage(currentCarriage)
                        .build()
                )
                .level(level)
                .exp(exp)
                .build();
    }
}
