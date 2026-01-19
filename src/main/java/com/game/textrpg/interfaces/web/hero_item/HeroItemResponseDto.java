package com.game.textrpg.interfaces.web.hero_item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeroItemResponseDto {
    private String itemName;
    private Integer itemCount;
    private String description;
}
