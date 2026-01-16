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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import javax.naming.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserFacade userFacade;
    private final JwtProvider jwtProvider;
    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    /**
     * 로그인
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @PostMapping("/login")
    public CommonResponse<UserInfo> Login(@RequestBody @Valid UserDto.LoginRequest request, HttpServletResponse response) throws AuthenticationException {
        UserCommand user = request.toCommand();
        UserInfo userInfo = userFacade.login(user);
        var userResponse = new UserDto.UserResponse(userInfo);

        String token = jwtProvider.createToken(userInfo);
        
        // HttpOnly 쿠키에 토큰 저장
        response.addHeader("set-Cookie", 
            "accessToken=" + token + "; Path=/; HttpOnly; SameSite=Strict; Max-Age=" + (60 * 60 * 6));

        return CommonResponse.success(userResponse);
    }

    /**
     * 회원가입
     * @param request
     * @return
     */
    @PostMapping("/register")
    public CommonResponse<UserInfo> Register(@RequestBody @Valid UserDto.RegistRequest request) {
        UserCommand user = request.toCommand();
        UserInfo userInfo = userFacade.registUser(user);
        var response = new UserDto.UserResponse(userInfo);

        return CommonResponse.success(response);
    }

    /**
     * 본인 정보 가져오기
     * @return
     */
    @GetMapping("/me")
    public CommonResponse<UserInfo> CheckAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication == null || !authentication.isAuthenticated()) {
            log.warn("인증되지 않은 요청");
            return null;
        }
        
        String userId = (String) authentication.getPrincipal();
        log.info("userId: {}", userId);
        
        UserInfo userInfo = userFacade.CheckAuth(userId);

        var response = new UserDto.UserResponse(userInfo);
        return CommonResponse.success(response);
    }

    /**
     * 로그아웃
     * @param response
     * @return
     */
    @PostMapping("/logout")
    public CommonResponse<Void> postMethodName(HttpServletResponse response) {
        response.addHeader("Set-Cookie", "accessToken=; Path=/; <ax-Age=0; HttpOnly; SameSite=Strict");
        return CommonResponse.success(null);
    }
    

}

