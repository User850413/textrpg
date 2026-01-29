package com.game.textrpg.infrastructure.action;

import java.util.List;

import com.game.textrpg.domains.action.ActionInfo;

public interface ActionService {
    List<ActionInfo> selectActionListByPlace(String placeId, String heroId);
}
