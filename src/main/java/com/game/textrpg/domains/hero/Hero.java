package com.game.textrpg.domains.hero;

import java.util.UUID;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name="heroes")
public class Hero {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name="location")
    private Place location;

    @OneToOne
    @JoinColumn(name="backpack")
    private Backpack backpack;

    @Column(name="level")
    private Integer level;

    @Column(name="exp")
    private Integer exp;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
