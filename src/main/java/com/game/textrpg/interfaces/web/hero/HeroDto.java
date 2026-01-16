package com.game.textrpg.interfaces.web.hero;

import com.game.textrpg.domains.hero.HeroCommand;
import com.game.textrpg.domains.hero.HeroInfo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @Getter
    @ToString
    public static class HeroResponse {
        private final String name;

        public HeroResponse(HeroInfo heroInfo){
            this.name = heroInfo.getName();
        }
    }

}
