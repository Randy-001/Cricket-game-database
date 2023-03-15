package com.example.CricketgameDatabase.controller;

import com.example.CricketgameDatabase.model.Player;
import com.example.CricketgameDatabase.model.Team;
import com.example.CricketgameDatabase.service.SequenceService;
import com.example.CricketgameDatabase.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamservice;

    @Autowired
    private SequenceService sequenceService;

    @GetMapping()
    public List<Team> getTeams()
    {
        return teamservice.findall();
    }
    @PostMapping
    public ResponseEntity<HashMap> addTeam(@RequestBody Team team)
    {
        team.setTeamId(sequenceService.updateCounter(Team.TEAM_SEQUENCE));
        for(int i =0 ;i<11;i++)
        {
            team.getPlayers().get(i).setPlayerId(sequenceService.updateCounter(Player.PLAYER_SEQUENCE));
        }
        teamservice.addTeam(team);
        HashMap<String, String> map = new HashMap<>();
        map.put("Added", "Success");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable int id)
    {
        return teamservice.getTeam(id);
    }
}
