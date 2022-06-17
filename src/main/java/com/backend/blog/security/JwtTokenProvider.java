package com.backend.blog.security;

import com.backend.blog.exception.BlogAPIException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.expiration-milliseconds}")
    private int jwtExpiration;

    public String generateToken(Authentication authentication) {

        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + this.jwtExpiration);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.ES512, jwtSecret)
                .compact();

        return token;
    }

    public String getUsernameFromJWT(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean isValidateToken(String token) {

        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {

            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Invalid JWT signature");

        } catch (MalformedJwtException ex) {

            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Invalid JWT token");

        } catch (ExpiredJwtException ex) {

            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Expired JWT token");

        } catch (UnsupportedJwtException ex) {

            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");

        } catch (IllegalArgumentException ex) {

            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "JWT claims string is empty");
        }

    }
}