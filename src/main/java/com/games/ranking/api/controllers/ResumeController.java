package com.games.ranking.api.controllers;

import com.games.ranking.api.models.entity.PlayerEntity;
import com.games.ranking.api.models.entity.ResumeEntity;
import com.games.ranking.api.models.response.ResumeResponse;
import com.games.ranking.api.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/v1/resume")
public class ResumeController {

    @Autowired
    ResumeService service;

    @GetMapping
    public List<ResumeEntity> getResume()  {
        return service.getResume();
    }
}
