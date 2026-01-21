package com.game.textrpg.infrastructure.place;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.game.textrpg.domains.place.Place;

public interface PlaceRepository extends JpaRepository<Place, UUID>{
    
    @Query(value="SELECT p FROM Place p WHERE p.placeId = 'HOME'")
    Place getFirstPlace();

    
}
