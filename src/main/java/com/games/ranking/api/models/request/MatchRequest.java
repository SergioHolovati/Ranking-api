package com.games.ranking.api.models.request;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MatchRequest {


    private String game;

    private Long winner;

    private Long loser;
}
