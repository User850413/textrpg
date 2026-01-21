package com.game.textrpg.domains.place_connection;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceConnectionId {
    
    @Column(name="from_place_id")
    private UUID fromPlaceId;

    @Column(name="to_place_id")
    private UUID toPlaceId;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof PlaceConnectionId)) return false;
        PlaceConnectionId that = (PlaceConnectionId) o;
        return Objects.equals(fromPlaceId, that.fromPlaceId) && Objects.equals(toPlaceId, that.toPlaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromPlaceId, toPlaceId);
    }
}
