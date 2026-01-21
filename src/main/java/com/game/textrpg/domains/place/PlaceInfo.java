package com.game.textrpg.domains.place;

import java.util.UUID;

import lombok.Getter;

@Getter
public class PlaceInfo {
    private final UUID id;
    private final String name;
    private final String placeId;
    
    public PlaceInfo(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.placeId = place.getPlaceId();
    }

    public PlaceInfo(UUID id, String name, String placeId){
        this.id = id;
        this.name = name;
        this. placeId = placeId;
    }
}
