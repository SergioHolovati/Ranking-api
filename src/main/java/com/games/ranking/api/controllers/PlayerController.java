package com.games.ranking.api.controllers;

import com.games.ranking.api.models.entity.PlayerEntity;
import com.games.ranking.api.models.request.PlayerRequest;
import com.games.ranking.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rest/v1/players")
public class PlayerController {

    @Autowired
    PlayerService service;

    @GetMapping
    public List<PlayerEntity> getPlayers()  {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PlayerEntity> getPlayerById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public String save(@RequestBody PlayerRequest playerRequest){

        return service.save(playerRequest);
    }

    @PutMapping("/{id}")
    public String edit(@RequestBody PlayerRequest playerRequest, @PathVariable Long id){
       return service.edit(playerRequest, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }
}
