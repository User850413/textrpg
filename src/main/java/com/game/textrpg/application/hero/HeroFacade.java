package com.game.textrpg.application.hero;

import java.util.List;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.hero.HeroCommand;
import com.game.textrpg.domains.hero.HeroInfo;
import com.game.textrpg.infrastructure.hero.HeroService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroFacade {

    private final HeroService heroService;

    /**
     * 유저 id에 따라 영웅 리스트 가져오기
     * @param userId
     * @return
     */
    public List<HeroInfo> findByUser(String userId) {
        if(userId == null){
            throw new NullPointerException();
        }

        List<HeroInfo> heroes = heroService.findByUser(userId);

        return heroes;
    }

    /**
     * 영웅 생성
     * @param command
     * @param userId
     * @return
     */
    public HeroInfo createHero(HeroCommand command, String userId) {
        if(command == null || userId == null){
            throw new NullPointerException();
        }
        HeroInfo hero = heroService.createHero(command, userId);

        return hero;
    }

    public void deleteHero(String heroId, String userId) {
        if(heroId ==null){
            throw new NullPointerException();
        }
        heroService.deleteHero(heroId, userId);
    }
    
}
