package com.game.textrpg.interfaces.web.backpack;

import lombok.Builder;
import lombok.Getter;

public class BackpackDto {

    @Getter
    @Builder    
    public static class BackpackResponse {
        private String id;
        private String name;
        private Integer maxCarriage;
        private Integer currentCarriage;
    }
}
