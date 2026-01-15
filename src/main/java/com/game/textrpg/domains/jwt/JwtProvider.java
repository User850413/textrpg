package com.game.textrpg.domains.jwt;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;
import com.game.textrpg.domains.user.UserInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    private final String secretKey = "textrpg_super_secret_key_which_is_long_enough_256bit";

    /**
     * 토큰 생성
     * @param userInfo
     * @return
     */
    public String createToken(UserInfo userInfo) {
        return Jwts.builder()
                .setSubject(String.valueOf(userInfo.getId()))
                .claim("userName", userInfo.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 6))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 토큰에서 id 추출
     * @param token
     * @return
     */
    public String getIdFromToken(String token) {
        return String.valueOf(
            Jwts.parserBuilder()
                    .setSigningKey(secretKey.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject()
        );
    }

    /**
     * 토큰 유효성 검사
     * @param token
     * @return
     */
    public boolean validateToken(String token) {
        try{
            Jwts.parserBuilder()
                    .setSigningKey(secretKey.getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
