package com.game.textrpg.infrastructure.user;

import com.game.textrpg.domains.user.UserCommand;
import com.game.textrpg.domains.user.UserInfo;


public interface UserService {
    UserInfo register(UserCommand user);
}
