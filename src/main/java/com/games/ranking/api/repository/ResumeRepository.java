package com.games.ranking.api.repository;

import com.games.ranking.api.models.entity.ResumeEntity;
import com.games.ranking.api.models.response.ResumeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeEntity,Long> {

    @Query(value = " SELECT \n" +
            "  p.id, p.name as name,  COUNT(mw.id) AS victories, count(ml.id) as defeats ,count(mw.id) + count(ml.id) as matches \n" +
            " FROM \n" +
            "    player AS p \n" +
            "        left JOIN \n" +
            "    matches AS mw ON p.id = mw.winner_id \n" +
            " \t\t left join \n" +
            "        matches as ml on ml.loser_id = p.id \n" +
            " GROUP BY p.id \n",nativeQuery = true)
    List<ResumeEntity> getResume();
}
