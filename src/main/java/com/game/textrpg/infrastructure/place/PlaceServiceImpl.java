package com.game.textrpg.infrastructure.place;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.game.textrpg.domains.place.Place;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService{

    private final PlaceRepository placeRepository;

    @Override
    public Place getFirstPlace() {
        Place firstPlace = placeRepository.getFirstPlace();
        if(firstPlace == null){
            throw new EmptyResultDataAccessException(1);
        }

        return firstPlace;
    }
    
}
