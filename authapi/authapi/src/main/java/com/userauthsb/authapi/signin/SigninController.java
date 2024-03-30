package com.userauthsb.authapi.signin;

import com.userauthsb.authapi.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("/signin")
public class SigninController {

    @Autowired
    private SigninService siSer;

    @PostMapping
    public ResponseEntity<User> authenticate(@RequestBody Map<String, String> payload) {
        if (siSer.authenticate(payload.get("username"), payload.get("password"))) {
            return new ResponseEntity<User>(HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

}
