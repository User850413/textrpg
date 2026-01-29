package com.game.textrpg.domains.placeAction;

import com.game.textrpg.domains.action.Action;
import com.game.textrpg.domains.place.Place;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="places_actions")
public class PlaceAction {
    
    @EmbeddedId
    private PlaceActionId id;

    @MapsId("placeId")
    @ManyToOne
    @JoinColumn(name="place_id")
    private Place place;

    @MapsId("actionId")
    @ManyToOne
    @JoinColumn(name="action_id")
    private Action action;
}
