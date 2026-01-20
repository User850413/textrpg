package com.game.textrpg.interfaces.web.place;

import lombok.Builder;
import lombok.Getter;

public class PlaceDto {
    
    @Getter
    @Builder
    public static class PlaceResponse {
        private String id;
        private String name;
        private String placeId;
    }
}
