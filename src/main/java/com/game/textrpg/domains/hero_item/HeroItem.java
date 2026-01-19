package com.game.textrpg.domains.hero_item;

import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.item.Item;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hero_items")
public class HeroItem {
    
    @EmbeddedId
    private HeroItemId id;
    
    @MapsId("heroId")
    @ManyToOne
    @JoinColumn(name="hero_id")
    private Hero hero;

    @MapsId("itemId")
    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @Column(name="count")
    private Integer count;
}
