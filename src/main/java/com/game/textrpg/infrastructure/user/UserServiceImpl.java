package com.game.textrpg.infrastructure.user;

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
    
}
