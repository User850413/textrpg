package com.game.textrpg.infrastructure.user;

import javax.naming.AuthenticationException;

import com.game.textrpg.domains.user.User;
import com.game.textrpg.domains.user.UserCommand;
import com.game.textrpg.domains.user.UserInfo;


public interface UserService {
    UserInfo register(UserCommand user);
    UserInfo login(UserCommand user)  throws AuthenticationException;
    UserInfo getUserById(String userId);
    User getEntityById(String userId);
}
