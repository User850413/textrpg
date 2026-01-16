package com.game.textrpg.infrastructure.backpack;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.game.textrpg.domains.backpack.Backpack;

public interface BackpackRepository extends JpaRepository<Backpack, UUID> {

    @Query(value="SELECT b FROM Backpack b WHERE b.isDefault=true")
    Backpack getDefaultBackpack();
    
}
