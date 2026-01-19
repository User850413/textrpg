package com.game.textrpg.domains.hero_item;

import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.item.Item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hero_items")
public class HeroItem {
    
    @Id
    @ManyToOne
    @JoinColumn(name="hero_id")
    private Hero hero;

    @Id
    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @Column(name="count")
    private Integer counts;
}
