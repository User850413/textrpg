package com.game.textrpg.infrastructure.place;

import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.place.PlaceInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService{

    private final PlaceRepository placeRepository;

    @Override
    public PlaceInfo getFirstPlace() {
        Place firstPlace = placeRepository.getFirstPlace();
        if(firstPlace == null){
            throw new EmptyResultDataAccessException(1);
        }

        return new PlaceInfo(firstPlace);
    }

    @Override
    public PlaceInfo getPlaceDetail(String placeIdStr) {
        UUID placeId = UUID.fromString(placeIdStr);
        if(placeId == null) throw new NullPointerException();

        Place place = placeRepository.findById(placeId).orElseThrow(() -> new NullPointerException("존재하지 않는 위치 id"));

        return new PlaceInfo(place);
    }
    
}
