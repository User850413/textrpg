package com.game.textrpg.domains.user;

import lombok.Getter;

@Getter
public class UserInfo {
    private final String id;
    private final String userId;
    private final String userName;

    public UserInfo(User user) {
        this.id = user.getId().toString();
        this.userId = user.getUserId().toString();
        this.userName = user.getUserName().toString();
    }
}
