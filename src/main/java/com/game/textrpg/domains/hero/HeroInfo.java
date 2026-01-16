package com.game.textrpg.domains.hero;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.user.User;

import lombok.Getter;

@Getter
public class HeroInfo {
    private final String name;
    private final String id;
    private final Place place;
    private final Backpack backpack;
    private final Integer level;
    private final Integer exp;
    private final User user;

    public HeroInfo(Hero hero) {
        this.name = hero.getName();
        this.id = hero.getId().toString();
        this.backpack = hero.getBackpack();
        this.place = hero.getLocation();
        this.level = hero.getLevel();
        this.exp = hero.getExp();
        this.user = hero.getUser();
    }
}
