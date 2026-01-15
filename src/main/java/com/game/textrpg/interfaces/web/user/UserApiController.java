package com.game.textrpg.interfaces.web.user;

import org.springframework.web.bind.annotation.RestController;

import com.game.textrpg.application.user.UserFacade;
import com.game.textrpg.common.response.CommonResponse;
import com.game.textrpg.domains.user.User;
import com.game.textrpg.domains.user.UserCommand;
import com.game.textrpg.domains.user.UserInfo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserFacade userFacade;
    
    @PostMapping("/login")
    public String postMethodName(@RequestBody @Valid UserDto.LoginRequest request) {
        
        return "";
    }

    @PostMapping("/register")
    public CommonResponse<User> postMethodName(@RequestBody @Valid UserDto.RegistRequest request) {
        UserCommand user = request.toCommand();
        UserInfo userInfo = userFacade.registUser(user);
        var response = new UserDto.UserResponse(userInfo);

        return CommonResponse.success(response);
    }
    

    // @GetMapping("/login")
    // public String getMethodName() {
    //     return "hi";
    // }
    
    
    

}
