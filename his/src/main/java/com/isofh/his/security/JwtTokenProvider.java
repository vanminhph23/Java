package com.isofh.his.security;

import com.isofh.his.dto.UserDto;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        return generateToken(authentication, null, null);
    }

    public String generateToken(Authentication authentication, List<Long> roleIds, List<Long> departmentIds) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        if (roleIds == null || roleIds.isEmpty()) {
            roleIds = userPrincipal.getRoleIds();
        }

        if (departmentIds == null || departmentIds.isEmpty()) {
            departmentIds = userPrincipal.getDepartmentIds();
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

        UserDto userDto = new UserDto(Long.parseLong(claims.getSubject()));
        userDto.setDepartmentIds((List<Long>) claims.get("departmentIds"));
        userDto.setRoleIds((List<Long>) claims.get("roleIds"));

        return userDto;
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
