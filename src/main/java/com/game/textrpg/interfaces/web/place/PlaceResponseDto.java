package com.game.textrpg.interfaces.web.place;

import java.util.List;

import com.game.textrpg.domains.place.PlaceInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PlaceResponseDto {
    
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlaceDetailResponseDto {
        private String id;
        private String name;
        private String placeId;
        private List<PlaceInfo> connectedPlace;
    }
}
