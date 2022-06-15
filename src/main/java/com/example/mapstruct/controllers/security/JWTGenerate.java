package com.example.mapstruct.controllers.security;

import com.example.mapstruct.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.security.auth.Subject;
import java.util.Date;
@Component
public class JWTGenerate {
    private  String KEY = "lU1S4M4R1N";
    public String generateToken(User user){
        return Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *2))
                .signWith(SignatureAlgorithm.HS256,KEY)
                .compact();

    }

    public boolean validateToken(String token, User user){
        return user.getEmail().equals(getEmail(token)) && !isTokenEpired(token);
    }

    public String getEmail(String token) {
        return getClaim(token).getSubject();
    }


    public boolean isTokenEpired(String token) {
        return getClaim(token).getExpiration().before(new Date());
    }

    public Claims getClaim(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
