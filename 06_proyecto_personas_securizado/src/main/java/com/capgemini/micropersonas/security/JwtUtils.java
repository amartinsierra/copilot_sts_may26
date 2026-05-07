package com.capgemini.micropersonas.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    
    // En una aplicación real, esto debería venir de application.properties
    private static final String CLAVE = "clavesecretaparagenerareltokendominada_y_que_sea_lo_suficientemente_larga";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 días

    public String generateToken(Authentication authentication) {
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("authorities", authentication.getAuthorities().stream()
                        .map(auth -> auth.getAuthority())
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(CLAVE.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(CLAVE.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

        String user = claims.getSubject();
        List<String> authorities = (List<String>) claims.get("authorities");
        
        return new UsernamePasswordAuthenticationToken(user, null, 
            authorities != null ? authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()) : List.of());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(CLAVE.getBytes()))
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}