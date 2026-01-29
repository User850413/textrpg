package com.game.textrpg.domains.heroSkill;

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
public class HeroSkillId implements Serializable{
    
    @Column(name="hero_id", columnDefinition = "uuid")
    private UUID heroId;

    @Column(name="skill_id", columnDefinition = "uuid")
    private UUID skillId;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof HeroSkillId)) return false;
        HeroSkillId that = (HeroSkillId) o;
        return Objects.equals(heroId, that.heroId) && Objects.equals(skillId, that.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroId, skillId);
    }
}
