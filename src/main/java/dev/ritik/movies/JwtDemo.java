package dev.ritik.movies;

import dev.ritik.movies.config.UserInfo;
import dev.ritik.movies.config.UserInfoUserDetails;
import dev.ritik.movies.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class JwtDemo {
    public static void main(String[] args){
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb290IiwiZXhwIjoxNjgxMDMzNDIyLCJpYXQiOjE2ODEwMTU0MjJ9.NAHVEoU20UcT2Nn4sDNvMxrq8d7_zvjdMC8QctiuE7Lq9QG9avZdeaM-ELe0KEjXIhvELFs6xAhe9B3cCqnxDw";
        System.out.println(jwtTokenUtil.isTokenExpired(token));
//        int expiration = 60*60*7;
//        String secret = "jjwtisfun";
//        Date currDate = new Date();
//
//        String token = Jwts.builder()
//                .setSubject("My Subject")
//                .setIssuedAt(currDate)
//                .setExpiration(new Date(System.currentTimeMillis()*expiration*1000))
//                .claim("name" , "ritik")
//                .signWith(SignatureAlgorithm.HS512 , secret)
//                .compact();
//        System.out.println(token);
//
//        Claims claim = Jwts.parser().setSigningKey("some random").parseClaimsJws(token).getBody();
    }
}
