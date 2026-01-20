package com.game.textrpg.infrastructure.hero;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.hero.HeroCommand;
import com.game.textrpg.domains.hero.HeroInfo;
import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.user.User;
import com.game.textrpg.infrastructure.backpack.BackpackService;
import com.game.textrpg.infrastructure.heroItem.HeroItemRepository;
import com.game.textrpg.infrastructure.place.PlaceService;
import com.game.textrpg.infrastructure.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class HeroServiceImpl implements HeroService{

    private final HeroItemRepository heroItemRepository;
    private final HeroRepository heroRepository;
    private final BackpackService backpackService;
    private final PlaceService placeService;
    private final UserService userService;


    @Override
    public List<HeroInfo> findByUser(String userIdStr) {
        UUID userId = UUID.fromString(userIdStr);
        List<HeroInfo> heroes = 
            heroRepository.findByUser_Id(userId).stream()
                .map(hero -> {
                    int itemCount = heroItemRepository.sumItemCountByHeroId(hero.getId());
                    return new HeroInfo(hero, itemCount);
                })
                .toList();

        return heroes;
    }

    @Override
    public HeroInfo createHero(HeroCommand command, String userId) {
        Backpack DefaultBackpack = backpackService.getDefaultBackpack();
        Place FirstPlace = placeService.getFirstPlace();
        User user = userService.getEntityById(userId);

        Hero hero = Hero.builder()
                .name(command.getName())
                .level(command.getLevel())
                .exp(command.getExp())
                .user(user)
                .backpack(DefaultBackpack)
                .location(FirstPlace)
                .build();


        Hero newHero = heroRepository.save(hero);

        return new HeroInfo(newHero, 0);
    }

    @Override
    public void deleteHero(String idStr, String userIdStr) {
        UUID heroId = UUID.fromString(idStr);
        UUID userId = UUID.fromString(userIdStr);

        long deleted = heroRepository.deleteByIdAndUser_Id(heroId, userId);
        if(deleted == 0){
            throw new IllegalStateException("삭제 권한이 없거나 대상이 없습니다.");
        }
    }

    @Override
    public HeroInfo getHeroDetail(String heroIdStr) {
        UUID heroId = UUID.fromString(heroIdStr);
        
        Hero hero = heroRepository.findById(heroId).orElse(null);
        if(hero == null){
            return null;
        }
        int itemCount = heroItemRepository.sumItemCountByHeroId(heroId);

        return new HeroInfo(hero, itemCount);
    }
    
}
