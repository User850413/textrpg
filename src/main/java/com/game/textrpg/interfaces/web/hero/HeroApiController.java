package com.game.textrpg.interfaces.web.hero;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.textrpg.application.hero.HeroFacade;
import com.game.textrpg.common.response.CommonResponse;
import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.hero.HeroInfo;
import com.game.textrpg.infrastructure.hero.HeroDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/hero")
@RequiredArgsConstructor
public class HeroApiController {

    private final HeroFacade heroFacade;
    private static final Logger log = LoggerFactory.getLogger(HeroApiController.class);
    
    @GetMapping("/byUser")
    public CommonResponse<List<HeroInfo>> getMethodName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()){
            log.warn("인증되지 않은 요청");
            return null;
        }

        String userId = (String) authentication.getPrincipal();
        log.info("userId: {}", userId);

        List<HeroInfo> heroes = heroFacade.findByUser(userId);

        return CommonResponse.success(heroes);
    }
    
}
