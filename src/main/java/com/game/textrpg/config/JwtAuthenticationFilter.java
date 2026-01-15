package com.game.textrpg.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.game.textrpg.domains.jwt.JwtProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String token = null;
        
        // 쿠키에서 토큰 추출
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("accessToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    logger.info("쿠키에서 토큰 추출 성공: " + token.substring(0, Math.min(20, token.length())) + "...");
                    break;
                }
            }
        } else {
            logger.info("쿠키가 없습니다");
        }

        // 토큰이 없으면 계속 진행
        if (token == null) {
            logger.warn("요청 경로: " + request.getRequestURI() + " - 토큰 없음");
            filterChain.doFilter(request, response);
            return;
        }

        try {
            // 토큰 유효성 검사
            if (jwtProvider.validateToken(token)) {
                String userId = jwtProvider.getIdFromToken(token);
                logger.info("토큰 검증 성공, userId: " + userId);
                
                // 인증 객체 생성
                UsernamePasswordAuthenticationToken authentication = 
                    new UsernamePasswordAuthenticationToken(userId, null, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                // SecurityContext에 설정
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                logger.warn("토큰 검증 실패");
            }
        } catch (Exception e) {
            logger.error("토큰 검증 중 예외 발생: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

}
