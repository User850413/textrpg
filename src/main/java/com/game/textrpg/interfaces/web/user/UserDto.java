package com.game.textrpg.interfaces.web.user;

import com.game.textrpg.domains.user.User;
import com.game.textrpg.domains.user.UserCommand;
import com.game.textrpg.domains.user.UserInfo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class UserDto {
    
    @Getter
    @NoArgsConstructor
    public static class RegistRequest {

        @NotEmpty(message = "아이디는 필수 입력값입니다.")
        @Size(min=5, max=15, message = "아이디는 5자 이상 15자 이하여야 합니다.")
        private String userId;

        @NotEmpty(message = "유저명은 필수 입력값입니다.")
        @Size(min=2, max=15, message = "유저명은 2자 이상 15자 이하여야 합니다.")
        private String userName;

        @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
        @Size(min=4, max=20, message = "비밀번호는 4자 이상 20자 이하여야 합니다.")
        private String userPwd;

        public UserCommand toCommand(){
            return UserCommand.builder()
                .userId(userId)
                .userName(userName)
                .userPwd(userPwd)
                .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class LoginRequest {
        
        @NotEmpty(message = "아이디는 필수 입력값입니다.")
        private String userId;

        @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
        private String userPwd;

        public UserCommand toCommand(){
            return UserCommand.builder()
                    .userId(userId)
                    .userPwd(userPwd)
                    .build();
        }

    }

    @Getter
    @ToString
    public static class UserResponse {
        private final String userId;
        private final String userName;

        public UserResponse(UserInfo userInfo) {
            this.userId = userInfo.getUserId();
            this.userName = userInfo.getUserName();
        }
    }
}
