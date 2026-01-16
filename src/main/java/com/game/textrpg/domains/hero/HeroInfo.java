package com.game.textrpg.domains.hero;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.user.User;

import lombok.Getter;

@Getter
public class HeroInfo {
    private final String id;
    private final Place place;
    private final Backpack backpack;
    private final User user;

    public HeroInfo(Hero hero) {
        this.id = hero.getId().toString();
        this.user = hero.getUser();
        this.backpack = hero.getBackpack();
        this.place = hero.getLocation();
    }
}
