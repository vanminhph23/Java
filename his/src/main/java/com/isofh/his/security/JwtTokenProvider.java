package com.isofh.his.security;

import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.exception.JWTTokenException;
import com.isofh.his.util.Util;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.security.jwtSecret}")
    private String jwtSecret;

    @Value("${app.security.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        return generateToken(authentication, null, null);
    }

    public String generateToken(Authentication authentication, Long roleId, Long departmentId) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        List<Long> roleIds = new ArrayList<>();
        if (roleId == null || roleId <= 0) {
            roleIds = userPrincipal.getRoleIds();
        } else {
            roleIds.add(roleId);
        }

        List<Long> departmentIds = new ArrayList<>();
        if (departmentId == null || departmentId <= 0) {
            departmentIds = userPrincipal.getDepartmentIds();
        } else {
            departmentIds.add(departmentId);
        }

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .claim("departmentIds", departmentIds)
                .claim("roleIds", roleIds)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public UserDto getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        UserDto userDto = new UserDto();
        userDto.setId(Long.parseLong(claims.getSubject()));

        userDto.setDepartmentIds(Util.convertIntToLong((List<Integer>) claims.get("departmentIds")));
        userDto.setRoleIds(Util.convertIntToLong((List<Integer>) claims.get("roleIds")));

        return userDto;
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            throw new JWTTokenException("Invalid JWT signature: " + authToken);
        } catch (MalformedJwtException ex) {
            throw new JWTTokenException("Invalid JWT token: " + authToken);
        } catch (ExpiredJwtException ex) {
            throw new JWTTokenException("Expired JWT token: " + authToken);
        } catch (UnsupportedJwtException ex) {
            throw new JWTTokenException("Unsupported JWT token: " + authToken);
        } catch (IllegalArgumentException ex) {
            throw new JWTTokenException("JWT claims string is empty: " + authToken);
        }
    }
}
