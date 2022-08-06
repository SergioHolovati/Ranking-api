package com.games.ranking.api.repository;

import com.games.ranking.api.models.entity.PlayerEntity;
import com.games.ranking.api.models.response.ResumeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
