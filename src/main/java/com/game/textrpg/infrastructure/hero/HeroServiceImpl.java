package com.game.textrpg.infrastructure.hero;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.hero.Hero;
import com.game.textrpg.domains.hero.HeroCommand;
import com.game.textrpg.domains.hero.HeroInfo;
import com.game.textrpg.domains.place.Place;
import com.game.textrpg.domains.user.User;
import com.game.textrpg.infrastructure.backpack.BackpackService;
import com.game.textrpg.infrastructure.place.PlaceService;
import com.game.textrpg.infrastructure.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService{

    private final HeroRepository heroRepository;
    private final BackpackService backpackService;
    private final PlaceService placeService;
    private final UserService userService;


    @Override
    public List<HeroInfo> findByUser(String userIdStr) {
        UUID userId = UUID.fromString(userIdStr);
        List<HeroInfo> heroes = 
            heroRepository.findByUser_Id(userId).stream()
                .map(HeroInfo::new)
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

        return new HeroInfo(newHero);
    }
    
}
