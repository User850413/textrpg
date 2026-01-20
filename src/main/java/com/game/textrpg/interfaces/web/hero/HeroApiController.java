package com.game.textrpg.interfaces.web.hero;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.textrpg.application.hero.HeroFacade;
import com.game.textrpg.common.response.CommonResponse;
import com.game.textrpg.common.util.SecurityUtils;
import com.game.textrpg.domains.hero.HeroCommand;
import com.game.textrpg.domains.hero.HeroInfo;
import com.game.textrpg.interfaces.web.hero.HeroResponseDto.GeneralHeroResponseDto;

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
    public CommonResponse<List<GeneralHeroResponseDto>> selectByUser() {
        String userId = SecurityUtils.getCurrentUserId();

        if(userId == null){
            log.warn("인증되지 않은 요청");
            return null;
        }
        List<GeneralHeroResponseDto> heroes 
            = heroFacade.findByUser(userId)
                        .stream()
                        .map(HeroInfo::toGeneralHeroResponseDto)
                        .toList();

        return CommonResponse.success(heroes);
    }

    @GetMapping("/{heroId}/detail")
    public String getHeroDetail(@PathVariable String heroId) {


        return new String();
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
    
    /**
     * 영웅 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public CommonResponse<Void> deleteHero(@PathVariable String id) {
        String userId = SecurityUtils.getCurrentUserId();
        heroFacade.deleteHero(id, userId);
        
        return CommonResponse.success(null);
    }
}
