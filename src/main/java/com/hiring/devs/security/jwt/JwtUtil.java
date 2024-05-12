package com.hiring.devs.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private Key secret;

    @PostConstruct
    protected void init(){
        byte[] apiSecretBYtes = new byte[64];
        new SecureRandom().nextBytes(apiSecretBYtes);
        secret = Keys.hmacShaKeyFor(apiSecretBYtes);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret.getEncoded()))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extracUserName(String token){return extractClaims(token, Claims::getSubject);}

    public Date extractExpiration(String token){return extractClaims(token, Claims::getExpiration);}

    private Boolean isTokenExpired(String token){return extractExpiration(token).before(new Date());}


    public String generateToken(String username, String role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 100 *60*60*10))
                .signWith(Keys.hmacShaKeyFor(secret.getEncoded())).compact();
    }


    public Boolean validateToken(String token , UserDetails userDetails){
        final String userName = extracUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }




}
