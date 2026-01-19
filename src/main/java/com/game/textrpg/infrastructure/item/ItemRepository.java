package com.game.textrpg.infrastructure.item;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.textrpg.domains.item.Item;

public interface ItemRepository extends JpaRepository<Item, UUID>{
    
}
