package com.game.textrpg.infrastructure.heroItem;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.hero_item.HeroItem;
import com.game.textrpg.domains.hero_item.HeroItemCommand;
import com.game.textrpg.domains.hero_item.HeroItemId;
import com.game.textrpg.domains.hero_item.HeroItemInfo;
import com.game.textrpg.domains.item.Item;
import com.game.textrpg.infrastructure.hero.HeroRepository;
import com.game.textrpg.infrastructure.item.ItemRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroItemServiceImpl implements HeroItemService{

    private final HeroRepository heroRepository;
    private final ItemRepository itemRepository;
    private final HeroItemRepository heroItemRepository;
    private final static Logger log = LoggerFactory.getLogger(HeroItemServiceImpl.class);

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
        String itemIdStr = command.getItemId();
        UUID itemId = UUID.fromString(command.getItemId());

        // hero가 해당 item 가지고 있는지 확인
        Hero hero = heroRepository.findById(heroId).orElseThrow(() -> new EntityNotFoundException("Hero not found"));
        List<HeroItem> items = heroItemRepository.findByHero_IdAndCountGreaterThan(heroId, 0);

        boolean contained = items.stream().anyMatch(i -> i.getItem().getId().toString().equals(itemIdStr));
        if(!contained){
            // 없을 시 maxCarriage와 currentCarriage 비교
            int maxCarriage = hero.getBackpack().getMaxCarriage();
            int currentCarriage = heroItemRepository.countItemCountByHeroId(heroId);

            if(currentCarriage >= maxCarriage){
                throw new IllegalStateException("your backpack is full");
            }
        }

        HeroItemId heroItemId = new HeroItemId(heroId, itemId);

        HeroItem heroItem = heroItemRepository.findById(heroItemId)
            .orElseGet(() -> {
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

    @Override
    public int heroCurrentCarriage(String heroIdStr) {
        UUID heroId = UUID.fromString(heroIdStr);

        int currentCarriageCount = heroItemRepository.findByHero_IdAndCountGreaterThan(heroId, 0).size();
        return currentCarriageCount;
    }
}
