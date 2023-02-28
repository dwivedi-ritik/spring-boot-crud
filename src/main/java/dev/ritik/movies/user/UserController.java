package dev.ritik.movies.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.ritik.movies.config.UserInfo;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo newUserEntity) {
        // System.out.println(newUserEntity.getEmail());
        UserInfo newUser = userService.addUser(newUserEntity);
        return new ResponseEntity<>(newUserEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public ResponseEntity<List<UserInfo>> showAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
}
