package com.userauthsb.authapi.onboard;

import com.userauthsb.authapi.BCrypt;
import com.userauthsb.authapi.User;
import com.userauthsb.authapi.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OnboardService {
    @Autowired
    private UserRepository onRep;

    public User createUser(String name, String username, String email, String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = onRep.findUserByUsername(username);
        if (user != null) {
            throw  new NoSuchElementException();
        }
        else {
            return onRep.insert(new User(name, username, email, hashed));
        }
    }
}
