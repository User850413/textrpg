package com.game.textrpg.interfaces.web.hero_item;

import com.game.textrpg.domains.hero_item.HeroItemCommand;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HeroItemDto {
    
    @Getter
    @NoArgsConstructor
    public static class addHeroItemRequest {
        
        @NotEmpty(message = "hero id는 필수입니다.")
        private String heroId;

        @NotEmpty(message = "item id는 필수입니다.")
        private String itemId;

        @NotNull
        @Min(0)
        private Integer count;

        public HeroItemCommand toCommand() {
            return HeroItemCommand.builder()
                    .heroId(heroId)
                    .itemId(itemId)
                    .count(count)
                    .build();
        }
    }
}
