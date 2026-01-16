package com.game.textrpg.interfaces.web.hero;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.textrpg.application.hero.HeroFacade;
import com.game.textrpg.common.response.CommonResponse;
import com.game.textrpg.common.util.SecurityUtils;
import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.hero.HeroCommand;
import com.game.textrpg.domains.hero.HeroInfo;
import com.game.textrpg.infrastructure.hero.HeroDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/hero")
@RequiredArgsConstructor
public class HeroApiController {

    private final HeroFacade heroFacade;
    private static final Logger log = LoggerFactory.getLogger(HeroApiController.class);
    
    /**
     * 유저 id로 영웅 리스트 가져오기
     * @return
     */
    @GetMapping("/byUser")
    public CommonResponse<List<HeroInfo>> selectByUser() {
        String userId = SecurityUtils.getCurrentUserId();

        if(userId == null){
            log.warn("인증되지 않은 요청");
            return null;
        }
        List<HeroInfo> heroes = heroFacade.findByUser(userId);

        return CommonResponse.success(heroes);
    }

    /**
     * 영웅 생성
     * @param request
     * @return
     */
    @PostMapping("/create")
    public CommonResponse<HeroInfo> createHero(@RequestBody @Valid HeroDto.CreateRequest request) {
        String userId = SecurityUtils.getCurrentUserId();

        if(userId == null){
            log.warn("인증되지 않은 요청");
            return null;
        }

        HeroCommand command = request.toCommand();
        HeroInfo hero = heroFacade.createHero(command, userId);

        return CommonResponse.success(hero);
    }
    
    @DeleteMapping("/delete/{id}")
    public CommonResponse<Void> deleteHero(@PathVariable String id) {
        heroFacade.deleteHero(id);
        
        return CommonResponse.success(null);
    }
    
}
