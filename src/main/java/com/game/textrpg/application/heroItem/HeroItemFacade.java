package com.game.textrpg.application.heroItem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.hero_item.HeroItemCommand;
import com.game.textrpg.domains.hero_item.HeroItemInfo;
import com.game.textrpg.infrastructure.heroItem.HeroItemService;
import com.game.textrpg.interfaces.web.hero_item.HeroItemResponseDto.HeroItemGetResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroItemFacade {

    private final HeroItemService heroItemService;

    /**
     * 영웅 id에 따라 아이템 리스트 가져오기
     * @param heroId
     * @return
     */
    public List<HeroItemInfo> findByHero(String heroId) {
        if(heroId == null){
            throw new NullPointerException();
        }

        List<HeroItemInfo> items = heroItemService.findByHero(heroId);
        return items;
    }

    /**
     * 영웅이 아이템 획득
     * @param heroItemCommand
     * @return
     */
    public HeroItemGetResponseDto addHeroItem(HeroItemCommand heroItemCommand){
        HeroItemInfo heroItemInfo = heroItemService.addHeroItem(heroItemCommand);
        int currentCount = heroItemService.heroCurrentCarriage(heroItemCommand.getHeroId().toString());

        HeroItemGetResponseDto heroItemResponse = heroItemInfo.toResponseDto();
        heroItemResponse.setCurrentCarriage(currentCount);

        return heroItemResponse;
    }
}
