package com.example.CricketgameDatabase.service;

import com.example.CricketgameDatabase.model.Team;
import com.example.CricketgameDatabase.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamService {


    private TeamRepository teamrepository;

    @Autowired
    public TeamService(TeamRepository teamrepository) {
        this.teamrepository = teamrepository;
    }

    public List<Team> findall() {
        return this.teamrepository.findAll();

    }


    public Team getTeam(int id)
    {
        return this.teamrepository.findById(id).get();
    }

    public void addTeam(Team team) {

        this.teamrepository.save(team);
    }
}
