package com.userauthsb.authapi.userinfo;

import com.userauthsb.authapi.User;
import com.userauthsb.authapi.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserRepository usRep;
    public User findInfo(String username) {
        return usRep.findUserByUsername(username);
    }
}
