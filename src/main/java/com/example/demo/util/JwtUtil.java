package com.example.demo.util;

import com.example.demo.model.CustomOAuth2User;
import com.example.demo.model.dto.UserDetailsDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.constant.MovieHallConstants.EMAIL_KEY;
import static com.example.demo.constant.MovieHallConstants.NAME_KEY;
import static com.example.demo.constant.MovieHallConstants.ROLE_KEY;
import static com.example.demo.constant.MovieHallConstants.SECRET;

/**
 * Utility class for jwt services
 */
@Component
@Log4j2
public class JwtUtil {

    /**
     * Method to extract user details from the token
     *
     * @param token token
     * @return user details
     */
    public UserDetailsDto extractUser(String token) {

        Claims claims = extractAllClaims(token);

        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setUserName((String)claims.get(NAME_KEY));
        userDetailsDto.setEmailId((String)claims.get(EMAIL_KEY));
        userDetailsDto.setRole((String)claims.get(ROLE_KEY));

        log.info("Extracted user details from the token");

        return userDetailsDto;
    }

    /**
     * Method to extract expiry date
     *
     * @param token token
     * @return expiry date
     */
    public Date extractExpiration(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration();
    }

    /**
     * Method to generate token for the given user details
     *
     * @param customOAuth2User customOAuth2User
     * @return token
     */
    public String generateToken(CustomOAuth2User customOAuth2User) {

        String userName = customOAuth2User.getUserName();
        String emailId = customOAuth2User.getEmailId();
        String role = customOAuth2User.getRole();

        Map<String, Object> claims = new HashMap<>();
        claims.put(NAME_KEY, userName);
        claims.put(EMAIL_KEY, emailId);
        claims.put(ROLE_KEY, role);

        log.info("Generating token for the user");

        return Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    /**
     * Method to validate token
     *
     * @param token token
     * @return status
     */
    public Boolean validateToken(String token) {
        return (isValid(token) && !isTokenExpired(token));
    }

    private boolean isValid(String token) {
        try {
            Jwts
                    .parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token);
            // Token is valid
            return true;
        } catch (Exception e) {

            // Token is invalid
            return false;
        }
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
