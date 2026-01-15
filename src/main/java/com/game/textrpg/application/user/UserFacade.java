package com.game.textrpg.application.user;

import javax.naming.AuthenticationException;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.user.UserCommand;
import com.game.textrpg.domains.user.UserInfo;
import com.game.textrpg.infrastructure.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserFacade {
    
    private final UserService userService;

    /**
     * 회원가입
     * @param command
     * @return
     */
    public UserInfo registUser(UserCommand command) {
        UserInfo user = userService.register(command);

        return user;
    }

    /**
     * 로그인
     * @param command
     * @return
     * @throws AuthenticationException
     */
    public UserInfo login(UserCommand command) throws AuthenticationException {
        UserInfo user = userService.login(command);

        return user;
    }

    /**
     * 본인 정보 가져오기
     * @param token
     * @return
     */
    public UserInfo CheckAuth(String token) {
        UserInfo user = userService.checkAuth(token);
        
        return user;
    }
}
