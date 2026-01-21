package com.game.textrpg.infrastructure.placeCoinnection;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.place_connection.PlaceConnection;
import com.game.textrpg.domains.place_connection.PlaceConnectionId;

public interface PlaceConnectionRepository extends JpaRepository<PlaceConnection, PlaceConnectionId>{

    @Query(value="select pc.toPlace from PlaceConnection pc where pc.fromPlace.id = :fromPlaceId")
    List<Place> findConnectedPlaces(@Param("fromPlaceId") UUID fromPlaceId);
}
