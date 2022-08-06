package com.games.ranking.api.service;
import com.games.ranking.api.models.entity.PlayerEntity;
import com.games.ranking.api.models.request.PlayerRequest;
import com.games.ranking.api.repository.PlayerRepository;
import com.games.ranking.core.util.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {


    @Autowired
    private GenericMapper mapper;
    @Autowired
    PlayerRepository repository;

    public List<PlayerEntity> getAll(){
        return repository.findAll();
    }

    public Optional<PlayerEntity> getById(Long id){
        return repository.findById(id);
    }
    public String save(PlayerRequest playerRequest) {
        try{
            repository.save(mapper.converter(playerRequest,PlayerEntity.class));
            return "Player created successfully";
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public String edit(PlayerRequest playerRequest, Long id) {
        try{
            Optional<PlayerEntity> entity = repository.findById(id);
            if(!entity.isEmpty()){
                entity.get().builder()
                        .name(playerRequest.getName())
                        .age(playerRequest.getAge())
                        .gender(playerRequest.getGender())
                        .build();
                repository.save(entity.get());
            }

            return "Player updated successfully";
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
