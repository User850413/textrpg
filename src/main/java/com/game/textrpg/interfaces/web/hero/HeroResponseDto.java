package com.game.textrpg.interfaces.web.hero;

import java.util.List;

import com.game.textrpg.interfaces.web.backpack.BackpackDto;
import com.game.textrpg.interfaces.web.place.PlaceDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HeroResponseDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GeneralHeroResponseDto {
        private String id;
        private String name;
        private PlaceDto.PlaceResponse location;
        private BackpackDto.BackpackResponse backpack;
        private Integer level;
        private Integer exp;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailHeroResponseDto {
        private String id;
        private String name;
        private PlaceDto.PlaceResponse location;
        private BackpackDto.BackpackResponse backpack;
        private String level;
        private Integer exp;
    }
}
