package com.userauthsb.authapi.onboard;

import com.userauthsb.authapi.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/onboard")
public class OnboardController {
    @Autowired
    private OnboardService onSer;

    @PostMapping
    public ResponseEntity<User> onboardUser(@RequestBody Map<String, String> payload) {

        try {
            return new ResponseEntity<User>(onSer.createUser(payload.get("name"),
                    payload.get("username"), payload.get("email"), payload.get("password")), HttpStatus.CREATED);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
