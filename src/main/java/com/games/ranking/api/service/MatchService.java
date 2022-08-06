package com.games.ranking.api.service;
import com.games.ranking.api.models.entity.MatchEntity;
import com.games.ranking.api.models.entity.PlayerEntity;
import com.games.ranking.api.models.request.MatchRequest;
import com.games.ranking.api.repository.MatchRepository;
import com.games.ranking.core.util.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private GenericMapper mapper;
    @Autowired
    MatchRepository repository;

    @Autowired
    PlayerService playerService;

    public List<MatchEntity> getAll(){
        return repository.findAll();
    }

    public Optional<MatchEntity> getById(Long id){
        return repository.findById(id);
    }
    public String save(MatchRequest matchRequest) {
        try{
            Optional<PlayerEntity> winner = playerService.getById(matchRequest.getWinner());
            Optional<PlayerEntity> loser = playerService.getById(matchRequest.getLoser());
            if(!winner.isEmpty() && !loser.isEmpty()){
                MatchEntity entity = MatchEntity.builder()
                        .winner(winner.get())
                        .loser(loser.get())
                        .game(matchRequest.getGame())
                        .build();
                repository.save(entity);
}

            return "Match created successfully";
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public String edit(MatchRequest request, Long id){
        try{
            Optional<MatchEntity> entity = repository.findById(id);
            if(!entity.isEmpty()){
                Optional<PlayerEntity> loser = playerService.getById(request.getLoser());
                Optional<PlayerEntity> winner = playerService.getById(request.getWinner());
                entity.get().builder()
                        .game(request.getGame())
                        .loser(loser.get())
                        .winner(winner.get())
                        .build();
            }
            return "Match updated successfully";

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public String delete(Long id){
        try{
            repository.deleteById(id);
            return "Successfully deleted player";
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

}
