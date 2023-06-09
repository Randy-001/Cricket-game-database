package com.example.CricketgameDatabase.controller;

import com.example.CricketgameDatabase.model.Match;
import com.example.CricketgameDatabase.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchservice;


    @PostMapping
    public Match addMatch(@RequestBody Match match)
    {
        return matchservice.add(match);
    }
    @GetMapping("/{id}/toss")
    public String toss(@PathVariable int id)
    {
       return matchservice.toss(id);
    }
    @GetMapping
    public List<Match> getMatch()
    {
        return matchservice.get();
    }
    @GetMapping("/{id}/start")
    public Match startGame(@PathVariable int id)
    {
        return matchservice.startGame(id);
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable int id)
    {
        return matchservice.getmatchbyid(id);
    }

}
