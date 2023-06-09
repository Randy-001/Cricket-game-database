package com.example.CricketgameDatabase.controller;


import com.example.CricketgameDatabase.model.TeamPlayer;
import com.example.CricketgameDatabase.service.TeamplayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private TeamplayerService teamplayerservice;
    @GetMapping("/{id}/match/{matchId}")
    public TeamPlayer getPlayer(@PathVariable int id, @PathVariable int matchId)
    {
        return this.teamplayerservice.findByIdAndMatchId(id,matchId);
    }
}
