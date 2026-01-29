package com.game.textrpg.domains.action;

import java.util.UUID;

import com.game.textrpg.domains.skill.Skill;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="actions")
public class Action {
    
    @Id
    @GeneratedValue(generator="UUID")
    private UUID id;
    
    @Column(name="name")
    @NonNull
    private String name;

    @Column(name="type")
    @NonNull
    private String type;

    @Column(name="base_time")
    private Integer baseTime;

    @Column(name="decay_rate")
    private double decayRate;

    @Column(name="min_time")
    private Integer minTime;

    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;
}
