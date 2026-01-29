package com.game.textrpg.application.place;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.game.textrpg.domains.action.ActionInfo;
import com.game.textrpg.domains.place.PlaceInfo;
import com.game.textrpg.infrastructure.action.ActionService;
import com.game.textrpg.infrastructure.place.PlaceService;
import com.game.textrpg.infrastructure.placeCoinnection.PlaceConnectionRepository;
import com.game.textrpg.interfaces.web.action.ActionResponseDto.GeneralActionResponseDto;
import com.game.textrpg.interfaces.web.place.PlaceResponseDto.PlaceDetailResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceFacade {
    
    private final ActionService actionService;
    private final PlaceService placeService;
    private final PlaceConnectionRepository placeConnectionRepository;

    /**
     * 장소 상세보기
     * @param placeId
     * @return
     */
    public PlaceDetailResponseDto getPlaceDetail(String placeId){
        PlaceInfo placeInfo = placeService.getPlaceDetail(placeId);
        List<PlaceInfo> connectedPlace 
            = placeConnectionRepository.findConnectedPlaces(UUID.fromString(placeId))
                .stream().map(pc -> new PlaceInfo(pc)).toList();
        PlaceDetailResponseDto placeDetailResponse 
            = PlaceDetailResponseDto.builder()
                .id(placeInfo.getId().toString())
                .name(placeInfo.getName())
                .placeId(placeInfo.getPlaceId())
                .connectedPlace(connectedPlace)
                .build();
        return placeDetailResponse;
    }

    public List<GeneralActionResponseDto> getActionsByPlace(String placeId, String heroId) {
        List<ActionInfo> actions = actionService.selectActionListByPlace(placeId, heroId);
        List<GeneralActionResponseDto> actionResponses = actions.stream()
            .map(a -> GeneralActionResponseDto.builder()
                .id(a.getId())
                .name(a.getName())
                .type(a.getType())
                .realTime(a.getRealTime())
                .build()
            ).toList();

        return actionResponses;
    }
}
