package com.game.textrpg.domains.heroSkill;

import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.skill.Skill;

import jakarta.persistence.Column;
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
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hero_skills")
public class HeroSkill {
    
    @EmbeddedId
    private HeroSkillId id;

    @MapsId("heroId")
    @ManyToOne
    @JoinColumn(name="hero_id")
    private Hero hero;

    @MapsId("skillId")
    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;

    @Column(name="level")
    private Integer level;

    @Column(name="exp")
    private Integer exp;
}
