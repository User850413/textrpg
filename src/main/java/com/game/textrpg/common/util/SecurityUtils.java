package com.game.textrpg.common.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Security 관련 유틸리티 클래스
 */
public class SecurityUtils {
    
    private static final Logger log = LoggerFactory.getLogger(SecurityUtils.class);
    
    /**
     * SecurityContext에서 현재 인증된 사용자의 ID를 가져옵니다
     * @return 사용자 ID, 인증되지 않은 경우 null
     */
    public static String getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication == null || !authentication.isAuthenticated()) {
            log.warn("인증되지 않은 요청");
            return null;
        }
        
        return (String) authentication.getPrincipal();
    }
    
    /**
     * 현재 사용자가 인증된 상태인지 확인합니다
     * @return 인증된 경우 true, 아니면 false
     */
    public static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }
}
