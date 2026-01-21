package com.game.textrpg.interfaces.web.place;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.textrpg.application.place.PlaceFacade;
import com.game.textrpg.common.response.CommonResponse;
import com.game.textrpg.interfaces.web.place.PlaceResponseDto.PlaceDetailResponseDto;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor
public class PlaceApiController {

    private static final Logger log = LoggerFactory.getLogger(PlaceApiController.class);
    private final PlaceFacade placeFacade;
    
    @GetMapping("/detail")
    public CommonResponse<PlaceDetailResponseDto> getPlaceDetail(@RequestParam String placeId) {
        PlaceDetailResponseDto placedetailResponse = placeFacade.getPlaceDetail(placeId);
        
        return CommonResponse.success(placedetailResponse);
    }

}
