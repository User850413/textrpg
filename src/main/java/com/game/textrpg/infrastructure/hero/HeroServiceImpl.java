package com.game.textrpg.infrastructure.hero;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.hero.HeroInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl  implements HeroService{

    private final HeroRepository heroRepository;

    @Override
    public List<HeroInfo> findByUser(String userIdStr) {
        UUID userId = UUID.fromString(userIdStr);
        List<HeroInfo> heroes = 
            heroRepository.findByUser_Id(userId).stream()
                .map(HeroInfo::new)
                .toList();

        return heroes;
    }
    
}
