package com.game.textrpg.infrastructure.placeAction;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.game.textrpg.domains.placeAction.PlaceAction;
import com.game.textrpg.domains.placeAction.PlaceActionId;
import com.game.textrpg.domains.action.Action;

public interface PlaceActionRepository extends JpaRepository<PlaceAction, PlaceActionId>{

    @Query(value="select pa.action from PlaceAction pa where pa.place.id = :placeId")
    List<Action> selectActionsByPlace(@Param("placeId") UUID placeId);
}
