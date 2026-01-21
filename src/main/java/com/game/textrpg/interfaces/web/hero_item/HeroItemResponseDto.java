package com.game.textrpg.interfaces.web.hero_item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class HeroItemResponseDto {

    @Setter
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HeroItemGetResponseDto{
        private String itemName;
        private Integer itemCount;
        private String description;
        private int currentCarriage;
    }
}
