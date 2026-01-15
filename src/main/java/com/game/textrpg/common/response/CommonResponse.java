package com.game.textrpg.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommonResponse<T> {
    
    private Result result;
    private T data;
    private Object message;
    private Number errorCode;

    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> CommonResponse success(T data) {
        return success(data, null);
    }

    public static CommonResponse fail(Object message, Number errorCode) {
        return CommonResponse.builder()
                .result(Result.FAILURE)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public static CommonResponse fail(Number errorCode) {
        return fail("응답 실패", errorCode);
    }

    public enum Result {
        SUCCESS, FAILURE
    }
}


