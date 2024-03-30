package com.userauthsb.authapi.userinfo;

import com.userauthsb.authapi.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService uiSer;

    @GetMapping("/{username}")
    public ResponseEntity<User> returnUser(@PathVariable String username) {
        User user = uiSer.findInfo(username);
        if (user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

}
