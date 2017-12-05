package com.shopbas.authentication.security;

import com.shopbas.authentication.domain.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class JwtTokenGenerator {
    public String generate(JwtUser jwtUser) throws UnsupportedEncodingException {
        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put("userId",String.valueOf(jwtUser.getId()));
        claims.put("role",jwtUser.getRole());

    return    Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"youtube".getBytes("UTF-8")).compact();
    }
}
