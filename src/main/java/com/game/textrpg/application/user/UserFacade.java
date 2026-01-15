package com.game.textrpg.application.user;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.user.UserCommand;
import com.game.textrpg.domains.user.UserInfo;
import com.game.textrpg.infrastructure.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserFacade {
    
    private final UserService userService;

    public UserInfo registUser(UserCommand command) {
        UserInfo user = userService.register(command);

        return user;
    }
}
