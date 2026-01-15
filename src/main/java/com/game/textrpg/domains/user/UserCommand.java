package com.game.textrpg.domains.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCommand {
    private final String userId;
    private final String userName;
    private String userPwd;

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .userName(userName)
                .userPwd(userPwd)
                .build();
    }

    public User toEntity(String encodedPwd){
        return User.builder()
                .userId(userId)
                .userName(userName)
                .userPwd(encodedPwd)
                .build();
    }
}
