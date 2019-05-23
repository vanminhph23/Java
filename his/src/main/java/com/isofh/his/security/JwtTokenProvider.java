package com.isofh.his.security;

import com.isofh.his.exception.security.JWTTokenException;
import com.isofh.his.util.Util;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        List<SimpleGrantedAuthority> authorities = userPrincipal.getAuthorities();

        List<String> privileges = new ArrayList<>();
        for (SimpleGrantedAuthority authority: authorities) {
            privileges.add(authority.getAuthority());
        }


        return generateToken(userPrincipal.getId(), userPrincipal.getDepartmentId(), userPrincipal.getRoleId(), userPrincipal.getMainDepartmentId(), privileges);
    }

    public String generateToken(Long id, Long departmentId, Long roleId, Long mainDepartmentId, List<String> privileges) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Long.toString(id))
                .claim("departmentId", departmentId)
                .claim("mainDepartmentId", mainDepartmentId)
                .claim("authorities", privileges)
                .claim("roleId", roleId)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public UserPrincipal decode(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        Long id = Long.valueOf(claims.getSubject());
        Integer departmentId = (Integer) claims.get("departmentId");
        Integer mainDepartmentId = (Integer) claims.get("mainDepartmentId");
        Integer roleId = (Integer) claims.get("roleId");
        List<String> privileges = (List<String>) claims.get("authorities");

        privileges = privileges == null ? new ArrayList<>() : privileges;

        return UserPrincipal.get(id, departmentId == null ? null : Long.valueOf(departmentId), roleId == null ? null : Long.valueOf(roleId), mainDepartmentId == null ? null : Long.valueOf(mainDepartmentId), privileges);
    }

    public void validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return;
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
