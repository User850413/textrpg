package com.game.textrpg.infrastructure.heroItem;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.hero_item.HeroItemInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroItemServiceImpl implements HeroItemService{

    private final HeroItemRepository heroItemRepository;

    @Override
    public List<HeroItemInfo> findByHero(String heroIdStr) {
        UUID heroId = UUID.fromString(heroIdStr);

        List<HeroItemInfo> items 
            = heroItemRepository.findByHero_Id(heroId).stream()
                .map(hi -> new HeroItemInfo(
                    hi.getItem().getName(),
                    hi.getCounts(),
                    hi.getItem().getDescription()
                ))
                .toList();

        return items;
    }
}
