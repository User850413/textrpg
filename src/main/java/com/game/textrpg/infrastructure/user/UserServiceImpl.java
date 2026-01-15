package com.game.textrpg.infrastructure.user;

import javax.naming.AuthenticationException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.game.textrpg.domains.user.User;
import com.game.textrpg.domains.user.UserCommand;
import com.game.textrpg.domains.user.UserInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserInfo register(UserCommand userCommand) {
        String encodedPwd = passwordEncoder.encode(userCommand.getUserPwd());

        User user = userCommand.toEntity(encodedPwd);
        User newUser = userRepository.save(user);

        return new UserInfo(newUser);
    }

    @Override
    public UserInfo login(UserCommand user) throws AuthenticationException {
        User foundUser = userRepository.findByUserId(user.getUserId());

        if(foundUser == null){
            throw new AuthenticationException("Invalid userId or password");
        }

        if (!passwordEncoder.matches(user.getUserPwd(), foundUser.getUserPwd())) {
            throw new AuthenticationException("Invalid userId or password");
        }
        
        return new UserInfo(foundUser);
    }
    
}
