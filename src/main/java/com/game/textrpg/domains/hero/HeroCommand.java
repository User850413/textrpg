package com.game.textrpg.domains.hero;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HeroCommand {
    private final String name;
    private final Integer level;
    private final Integer exp;
}
