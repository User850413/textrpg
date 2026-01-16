package com.game.textrpg.infrastructure.hero;

import com.game.textrpg.domains.hero.HeroCommand;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HeroDto {

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

}
