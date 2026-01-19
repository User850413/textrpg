package com.game.textrpg.domains.item;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemCommand {
    private final String name;
    private final String description;
}
