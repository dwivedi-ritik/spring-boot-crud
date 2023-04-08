package dev.ritik.movies.user;

import java.util.List;

import dev.ritik.movies.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo newUserEntity) {
        UserInfo newUser = userService.addUser(newUserEntity);
        return new ResponseEntity<>(newUserEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public ResponseEntity<List<UserInfo>> showAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "/authenticate" , method = RequestMethod.POST)
    public ResponseEntity<String> authenticateUser(@RequestBody AuthUser authUser){
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUser.getUsername() , authUser.getPassword()));
        if(!authentication.isAuthenticated()) return new ResponseEntity<>("Unauthorized" , HttpStatus.UNAUTHORIZED);
        String token = jwtTokenUtil.generateToken(authUser);
        return new ResponseEntity<String>(token , HttpStatus.OK);

    }
}
