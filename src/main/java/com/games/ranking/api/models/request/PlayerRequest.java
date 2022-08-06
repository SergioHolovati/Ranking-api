package com.games.ranking.api.models.request;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class PlayerRequest {

    private String name;

    private Integer age;

    private String gender;
}
