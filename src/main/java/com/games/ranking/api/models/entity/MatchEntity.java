package com.games.ranking.api.models.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches")
public class MatchEntity {


    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String game;

    @ManyToOne
    @JoinColumn
    private PlayerEntity winner;

    @ManyToOne
    @JoinColumn
    private PlayerEntity loser;
}
