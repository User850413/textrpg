package com.game.textrpg.interfaces.web.hero;

import com.game.textrpg.domains.hero.HeroCommand;
import com.game.textrpg.domains.hero.HeroInfo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class HeroDto {

    /**
     * 영웅 생성 dto
     */
    @Getter
    @NoArgsConstructor
    public static class CreateRequest {

        @NotEmpty(message = "이름은 필수 입력값입니다.")
        @Size(max=10, message = "이름은 10자 이하여야 합니다.")
        private String name;

        public HeroCommand toCommand() {
            return HeroCommand.builder()
                    .name(name)
                    .level(1)
                    .exp(0)
                    .build();
        }
    }

    /**
     * 영웅 움직임 dto
     */
    @Getter
    @NoArgsConstructor
    public static class moveRequest {

        @NotEmpty(message= "hero id는 필수 입력값입니다.")
        private String heroId;

        @NotEmpty(message="place id는 필수 입력값입니다.")
        private String placeId;
    }
}
