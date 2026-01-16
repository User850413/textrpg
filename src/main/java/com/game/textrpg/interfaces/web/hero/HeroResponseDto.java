package com.game.textrpg.interfaces.web.hero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeroResponseDto {
    private String id;
    private String name;
    private String locationName;
    private String locationId;
    private String backpackName;
    private Integer backpackMax;
    private Integer level;
    private Integer exp;
}


