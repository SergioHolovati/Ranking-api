package com.games.ranking.api.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerResponse {

    private Long id;
    private String name;
    private Integer age;
    private String gender;

}
