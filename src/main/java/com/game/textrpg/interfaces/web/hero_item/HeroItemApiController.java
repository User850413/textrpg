package com.game.textrpg.interfaces.web.hero_item;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.textrpg.application.heroItem.HeroItemFacade;
import com.game.textrpg.common.response.CommonResponse;
import com.game.textrpg.domains.hero_item.HeroItemCommand;
import com.game.textrpg.domains.hero_item.HeroItemInfo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/heroItem")
@RequiredArgsConstructor
public class HeroItemApiController {

    private final HeroItemFacade heroItemFacade;
    
    @GetMapping("/{heroId}")
    public CommonResponse<List<HeroItemInfo>> getMethodName(@PathVariable String heroId) {
        List<HeroItemInfo> items = heroItemFacade.findByHero(heroId);

        return CommonResponse.success(items);
    }

    @PostMapping("/getItem")
    public CommonResponse<HeroItemInfo> addHeroItem(@RequestBody @Valid HeroItemDto.addHeroItemRequest request) {
        HeroItemCommand command = request.toCommand();

        HeroItemInfo heroItem = heroItemFacade.addHeroItem(command);
        
        return CommonResponse.success(heroItem);
    }
    
    
}
