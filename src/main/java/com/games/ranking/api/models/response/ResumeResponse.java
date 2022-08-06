package com.games.ranking.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResumeResponse {
    private String name;
    private Integer matches;
    private Integer victories;
    private Integer defeats;
}
