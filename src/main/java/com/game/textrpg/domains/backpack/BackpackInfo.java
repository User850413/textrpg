package com.game.textrpg.domains.backpack;

import java.util.UUID;

import lombok.Getter;

@Getter
public class BackpackInfo {
    private final UUID id;
    private final String name;
    private final Integer maxCarriage;

    public BackpackInfo(Backpack backpack) {
        this.id = backpack.getId();
        this.name = backpack.getName();
        this.maxCarriage = backpack.getMaxCarriage();
    }
}
