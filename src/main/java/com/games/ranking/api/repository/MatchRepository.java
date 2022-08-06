package com.games.ranking.api.repository;


import com.games.ranking.api.models.entity.MatchEntity;
import com.games.ranking.api.models.response.ResumeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {




}
