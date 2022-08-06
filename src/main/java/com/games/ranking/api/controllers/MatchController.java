package com.games.ranking.api.controllers;

import com.games.ranking.api.models.entity.MatchEntity;
import com.games.ranking.api.models.request.MatchRequest;
import com.games.ranking.api.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rest/v1/matches")
public class MatchController {

    @Autowired
    MatchService service;

    @GetMapping
    public List<MatchEntity> getPlayers()  {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MatchEntity> getMatchById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public String saveMatch(@RequestBody MatchRequest matchRequest){

        return service.save(matchRequest);
    }

    @PutMapping("/{id}")
    public String edit(@RequestBody MatchRequest matchRequest, @PathVariable Long id){
        return service.edit(matchRequest,id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }
}
