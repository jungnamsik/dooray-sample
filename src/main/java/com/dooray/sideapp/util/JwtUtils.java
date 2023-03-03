package com.dooray.sideapp.util;

import java.security.GeneralSecurityException;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtUtils {
    private static final String BEARER = "Bearer ";
    private static final int BEARER_LEN = 7;

    public static Map<String, Object> parseJws(final String key, final String jwsString) throws GeneralSecurityException {
        Jws<Claims> jws = null;
        try {
            jws = Jwts.parserBuilder()
                    .setSigningKey(key.getBytes())
                    .build()
                    .parseClaimsJws(jwsString);
            return jws.getBody();
        } catch (final JwtException e) {
            throw new GeneralSecurityException(e.getMessage());
        }    
    }

    public static Map<String, Object> parseJwsOnAuthorizationHeader(final String key, final String jwsStringOnHeader) throws GeneralSecurityException {
        int pos = jwsStringOnHeader.indexOf(BEARER);
        if (pos == -1) {
            throw new GeneralSecurityException("Invalid Jws Value");
        }

        return parseJws(key, jwsStringOnHeader.substring(pos + BEARER_LEN));
    }
}