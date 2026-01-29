package com.game.textrpg.infrastructure.action;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.game.textrpg.domains.action.ActionInfo;
import com.game.textrpg.domains.heroSkill.HeroSkill;
import com.game.textrpg.domains.heroSkill.HeroSkillId;
import com.game.textrpg.domains.skill.Skill;
import com.game.textrpg.domains.skill.SkillRepository;
import com.game.textrpg.infrastructure.heroSkill.HeroSkillRepository;
import com.game.textrpg.infrastructure.placeAction.PlaceActionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {

    private static final Logger log = LoggerFactory.getLogger(ActionServiceImpl.class);
    private final HeroSkillRepository heroSkillRepository;
    private final PlaceActionRepository placeActionRepository;

    @Override
    public List<ActionInfo> selectActionListByPlace(String placeIdStr, String heroIdStr) {
        log.info("placeId : {}, heroId : {}", placeIdStr, heroIdStr);
        UUID placeId = UUID.fromString(placeIdStr);
        UUID heroId = UUID.fromString(heroIdStr);

        // place에 종속된 actions 가져오기
        List<ActionInfo> actions 
            = placeActionRepository.selectActionsByPlace(placeId).stream()
                .map(a -> new ActionInfo(a))
                .toList();

        // action별 상태
        for(ActionInfo action : actions){
            Skill skill = action.getSkill();
            HeroSkillId id = new HeroSkillId(heroId, skill.getId());

            HeroSkill hs = heroSkillRepository.findById(id).orElseThrow(() 
                -> new NullPointerException("HeroSkill not found: hero=" + heroId + ", skill=" + skill.getId()));
            double baseTime = action.getBaseTime();
            double decayRate = action.getDecayRate();
            double level = hs.getLevel();

            double calculatedTime = baseTime * Math.pow(decayRate, level - 1);
            Integer minTime = action.getMinTime();

            double realTime = Math.max(calculatedTime, minTime);
            double stableTime = Math.round(realTime*10)/10;

            log.info("base time : {}, decay rate : {}, level : {}, calculatedTime : {}, min time: {}, real time : {}, stable time : {}"
                ,baseTime
                ,decayRate
                ,level
                ,calculatedTime
                ,minTime
                ,realTime
                ,stableTime
            );

            action.setRealTime(stableTime);
        }

        return actions;
    }
}
