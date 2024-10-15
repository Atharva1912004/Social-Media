package com.example.socialmedia.authentication;

import com.example.socialmedia.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtGenerator {
    private static final String SECRET_KEY="7856856745847347457347357837458457357374578457";

    public String generateToken(User user){
        Map<String,String > emailMap=new HashMap();
        emailMap.put("email",user.getEmail());
        return Jwts
                .builder()
                .setSubject(String.valueOf(user.getUserId()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()*1000*60))
                .setClaims(emailMap)
                .compact();

    }

    private Key getSigningKey(){
        byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decode);
    }
}
