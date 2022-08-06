package com.games.ranking.api.service;

import com.games.ranking.api.models.entity.PlayerEntity;
import com.games.ranking.api.models.entity.ResumeEntity;
import com.games.ranking.api.models.response.ResumeResponse;
import com.games.ranking.api.repository.PlayerRepository;
import com.games.ranking.api.repository.ResumeRepository;
import com.games.ranking.core.util.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ResumeService {


    @Autowired
    private GenericMapper mapper;

    @Autowired
    ResumeRepository repository;

    public List<ResumeEntity> getResume(){
        return repository.getResume().stream().toList();

    }

}
