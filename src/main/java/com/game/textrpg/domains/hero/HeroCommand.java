package com.game.textrpg.domains.hero;

import java.util.UUID;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.user.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HeroCommand {
    private final String name;
    private final Integer level;
    private final Integer exp;

    // public Hero toEntity(Backpack backpack, Place location, User user) {
    //     return Hero.builder()
    //             .name(name)
    //             .location(location)
    //             .backpack(backpack)
    //             .level(level)
    //             .exp(exp)
    //             .user(user)
    //             .build();
    // }
}
