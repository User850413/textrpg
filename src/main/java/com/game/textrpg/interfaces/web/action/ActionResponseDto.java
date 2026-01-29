package com.game.textrpg.interfaces.web.action;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ActionResponseDto {
    
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GeneralActionResponseDto{
        private String id;
        private String name;
        private String type;
        private double realTime;
    }
}
