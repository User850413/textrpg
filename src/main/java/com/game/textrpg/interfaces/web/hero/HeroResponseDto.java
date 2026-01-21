package com.game.textrpg.interfaces.web.hero;

import com.game.textrpg.domains.backpack.BackpackInfo;
import com.game.textrpg.domains.place.PlaceInfo;

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
        private PlaceInfo location;
        private BackpackInfo backpack;
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
        private PlaceInfo location;
        private BackpackInfo backpack;
        private String level;
        private Integer exp;
    }
}
