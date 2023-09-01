package com.example.demo.util;

import com.example.demo.exception.ErrorMessage;
import com.example.demo.model.dto.UserDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

@Component
@Log4j2
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {

        try {
            String authorizationHeader = httpServletRequest.getHeader("Authorization");

            String token = null;
            UserDetailsDto userDetailsDto = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                token = authorizationHeader.substring(7);
                userDetailsDto = jwtUtil.extractUser(token);
            }

            if (Objects.nonNull(userDetailsDto)) {

                if (jwtUtil.validateToken(token)) {

                    log.info("Valid token");

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetailsDto, null,
                                    Collections.singletonList(new SimpleGrantedAuthority(userDetailsDto.getRole())));

                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(usernamePasswordAuthenticationToken);
                } else {
                    log.error("Invalid token");
                }
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (ExpiredJwtException e) {
            log.error("Token expired - {}", e.getMessage());
            ErrorMessage errorMessage =
                    new ErrorMessage(HttpStatus.FORBIDDEN.value(), new Date(), e.getMessage(), "Provide valid token");

            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(errorMessage));
        }
        catch (Exception e) {
            log.error("Exception in JwtFilter. {}", e.getMessage());
            ErrorMessage errorMessage =
                    new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), e.getMessage(), "");

            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(errorMessage));
        }
    }
}
