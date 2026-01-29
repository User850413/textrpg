package com.game.textrpg.domains.action;

import com.game.textrpg.domains.skill.Skill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionInfo {
    private String id;
    private String name;
    private String type;
    private Integer baseTime;
    private double decayRate;
    private Integer minTime;
    private Skill skill;
    private double realTime;

    public ActionInfo(Action action){
        this.id = action.getId().toString();
        this.name = action.getName();
        this.type = action.getType();
        this.baseTime = action.getBaseTime();
        this.decayRate = action.getDecayRate();
        this.minTime = action.getMinTime();
        this.skill = action.getSkill();
    }
}
