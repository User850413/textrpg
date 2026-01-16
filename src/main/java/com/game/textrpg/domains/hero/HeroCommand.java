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
    private final String locationId;
    private final String backpackId;
    private final Integer level;
    private final Integer exp;
    private final String userId;

    public Hero toEntity() {
        User user = 
            User.builder()
                .id(UUID.fromString(userId))
                .build();
        
        Place place = 
            Place.builder()
                .id(UUID.fromString(locationId))
                .build();
            
        Backpack backpack = 
            Backpack.builder()
                    .id(UUID.fromString(backpackId))
                    .build();

        return Hero.builder()
                .name(name)
                .location(place)
                .backpack(backpack)
                .level(level)
                .exp(exp)
                .user(user)
                .build();
    }
}
