package dev.ritik.movies;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtDemo {
    public static void main(String[] args){
        int expiration = 60*60*7;
        String secret = "jjwtisfun";
        Date currDate = new Date();

        String token = Jwts.builder()
                .setSubject("My Subject")
                .setIssuedAt(currDate)
                .setExpiration(new Date(System.currentTimeMillis()*expiration*1000))
                .claim("name" , "ritik")
                .signWith(SignatureAlgorithm.HS512 , secret)
                .compact();
        System.out.println(token);

        Claims claim = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        System.out.println(claim.getExpiration());
    }
}
