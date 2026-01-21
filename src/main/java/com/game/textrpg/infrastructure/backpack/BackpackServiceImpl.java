package com.game.textrpg.infrastructure.backpack;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.game.textrpg.domains.backpack.Backpack;
import com.game.textrpg.domains.backpack.BackpackInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BackpackServiceImpl implements BackpackService{

    private final BackpackRepository backpackRepository;

    @Override
    public BackpackInfo getDefaultBackpack() {
        Backpack defaultBackpack = backpackRepository.getDefaultBackpack();

        if(defaultBackpack == null){
            throw new EmptyResultDataAccessException(1);
        }

        return new BackpackInfo(defaultBackpack);
    }
    
}
