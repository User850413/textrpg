package com.game.textrpg.domains.place_connection;

import com.game.textrpg.domains.place.Place;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="place_connections")
public class PlaceConnection {
    @EmbeddedId
    private PlaceConnectionId id;

    @MapsId("fromPlaceId")
    @ManyToOne
    @JoinColumn(name="from_place_id")
    private Place fromPlace;

    @MapsId("toPlaceId")
    @ManyToOne
    @JoinColumn
    private Place toPlace;
}
