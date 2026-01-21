package com.game.textrpg.infrastructure.place;

import com.game.textrpg.domains.place.PlaceInfo;

public interface PlaceService {
    PlaceInfo getFirstPlace();    
    
    PlaceInfo getPlaceDetail(String placeId);
}
