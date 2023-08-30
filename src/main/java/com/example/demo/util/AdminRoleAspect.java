package com.example.demo.util;

import com.example.demo.annotation.AdminOnly;
import com.example.demo.enumeration.Roles;
import com.example.demo.model.dto.UserDetailsDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

/**
 * Aspect class for @AdminOnly annotation
 */
@Aspect
@Component
public class AdminRoleAspect {

    /**
     * Method to verify user has admin role or not
     *
     * @param joinPoint joinPoint
     * @param adminOnly adminOnly
     */
    @Before(value = "@annotation(adminOnly)")
    public void checkAdminRole(JoinPoint joinPoint, AdminOnly adminOnly) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        UserDetailsDto userDetailsDto = (UserDetailsDto)authentication.getPrincipal();

        if (StringUtils.isEmpty(userDetailsDto.getRole()) || Roles.USER
                .getValue()
                .equals(userDetailsDto.getRole())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied. Admin role required.");
        }
    }
}
