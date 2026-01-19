package com.game.textrpg.domains.hero_item;

import java.io.Serializable;
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
public class HeroItemId implements Serializable{

    @Column(name="hero_id")
    private UUID heroId;

    @Column(name="item_id")
    private UUID itemId;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof HeroItemId)) return false;
        HeroItemId that = (HeroItemId) o;
        return Objects.equals(heroId, that.heroId) && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroId, itemId);
    }

}
