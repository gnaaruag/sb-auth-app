package com.userauthsb.authapi.signin;


import com.userauthsb.authapi.BCrypt;
import com.userauthsb.authapi.User;
import com.userauthsb.authapi.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SigninService {
    @Autowired
    private UserRepository siRep;

    public Boolean authenticate (String username, String password) {
        User user = siRep.findUserByUsername(username);
        if (user == null) {
            return false;
        }
        else {
            return BCrypt.checkpw(password, user.getPassword());
        }

    }

}
