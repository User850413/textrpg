package com.game.textrpg.domains.placeAction;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PlaceActionId implements Serializable{
    
    @Column(name="place_id")
    private UUID placeId;

    @Column(name="action_id")
    private UUID actionId;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof PlaceActionId)) return false;
        PlaceActionId that = (PlaceActionId) o;
        return Objects.equals(placeId, that.placeId) && Objects.equals(actionId, that.actionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, actionId);
    }
}
