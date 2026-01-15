package com.game.textrpg.interfaces.web.user;

import org.springframework.web.bind.annotation.RestController;

import com.game.textrpg.application.user.UserFacade;
import com.game.textrpg.common.response.CommonResponse;
import com.game.textrpg.domains.jwt.JwtProvider;
import com.game.textrpg.domains.user.User;
import com.game.textrpg.domains.user.UserCommand;
import com.game.textrpg.domains.user.UserInfo;

import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserFacade userFacade;
    private final JwtProvider jwtProvider;
    
    @PostMapping("/login")
    public CommonResponse<User> postMethodName(@RequestBody @Valid UserDto.LoginRequest request, HttpServletResponse response) throws AuthenticationException {
        UserCommand user = request.toCommand();
        UserInfo userInfo = userFacade.login(user);
        var userResponse = new UserDto.UserResponse(userInfo);

        String token = jwtProvider.createToken(userInfo);
        
        // HttpOnly 쿠키에 토큰 저장
        response.addHeader("accessToken-tpg", 
            "jwtToken=" + token + "; Path=/; HttpOnly; Secure; SameSite=Strict; Max-Age=" + (60 * 60 * 6));

        return CommonResponse.success(userResponse);
    }

    @PostMapping("/register")
    public CommonResponse<User> postMethodName(@RequestBody @Valid UserDto.RegistRequest request) {
        UserCommand user = request.toCommand();
        UserInfo userInfo = userFacade.registUser(user);
        var response = new UserDto.UserResponse(userInfo);

        return CommonResponse.success(response);
    }
}
