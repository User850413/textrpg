package com.game.textrpg.infrastructure.heroItem;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.hero_item.HeroItem;
import com.game.textrpg.domains.hero_item.HeroItemCommand;
import com.game.textrpg.domains.hero_item.HeroItemId;
import com.game.textrpg.domains.hero_item.HeroItemInfo;
import com.game.textrpg.domains.item.Item;
import com.game.textrpg.infrastructure.hero.HeroRepository;
import com.game.textrpg.infrastructure.item.ItemRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroItemServiceImpl implements HeroItemService{

    private final HeroRepository heroRepository;
    private final ItemRepository itemRepository;
    private final HeroItemRepository heroItemRepository;

    @Override
    public List<HeroItemInfo> findByHero(String heroIdStr) {
        UUID heroId = UUID.fromString(heroIdStr);

        List<HeroItemInfo> items 
            = heroItemRepository.findByHero_IdAndCountGreaterThan(heroId, 0).stream()
                .map(hi -> new HeroItemInfo(
                    hi.getItem().getName(),
                    hi.getCount(),
                    hi.getItem().getDescription()
                ))
                .toList();

        return items;
    }

    @Override
    @Transactional
    public HeroItemInfo addHeroItem(HeroItemCommand command) {
        UUID heroId = UUID.fromString(command.getHeroId());
        UUID itemId = UUID.fromString(command.getItemId());

        HeroItemId heroItemId = new HeroItemId(heroId, itemId);

        HeroItem heroItem = heroItemRepository.findById(heroItemId)
            .orElseGet(() -> {
                Hero hero = heroRepository.findById(heroId)
                    .orElseThrow(() -> new IllegalArgumentException("Hero not found"));
                Item item = itemRepository.findById(itemId)
                    .orElseThrow(() -> new IllegalArgumentException("Item not found"));
                
                return HeroItem.builder()
                    .id(heroItemId)
                    .hero(hero)
                    .item(item)
                    .count(0)
                    .build();
            });
        
        heroItem.setCount(heroItem.getCount() + command.getCount());
        HeroItem saved = heroItemRepository.save(heroItem);

        return new HeroItemInfo(saved.getItem().getName(), saved.getCount(), saved.getItem().getDescription());
    }
}
