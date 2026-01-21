package com.game.textrpg.infrastructure.hero;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.game.textrpg.domains.hero.Hero;

public interface HeroRepository  extends JpaRepository<Hero, UUID>{
    List<Hero> findByUser_Id(UUID userId);
    long deleteByIdAndUser_Id(UUID heroId, UUID userId);

    @Modifying(clearAutomatically = true)
    @Query(value="update Hero h set h.location.id = :placeId where h.user.id = :userId and h.id = :heroId")
    int moveHero(@Param("userId")UUID userId, @Param("heroId")UUID heroId, @Param("placeId")UUID placeId);
}
