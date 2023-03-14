package com.example.CricketgameDatabase.controller;

import com.example.CricketgameDatabase.model.Team;
import com.example.CricketgameDatabase.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamservice;

    @GetMapping()
    public List<Team> getTeams()
    {
        return teamservice.findall();
    }
    @PostMapping
    public ResponseEntity<String> addTeam(@RequestBody Team team)
    {
        teamservice.addTeam(team);
        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable int id)
    {
        return teamservice.getTeam(id);
    }
}
