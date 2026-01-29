package com.game.textrpg.infrastructure.heroSkill;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.textrpg.domains.heroSkill.HeroSkill;
import com.game.textrpg.domains.heroSkill.HeroSkillId;

public interface HeroSkillRepository extends JpaRepository<HeroSkill, HeroSkillId>{
}
