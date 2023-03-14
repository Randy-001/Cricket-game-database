package com.example.CricketgameDatabase.service;

import com.example.CricketgameDatabase.model.TeamPlayer;
import com.example.CricketgameDatabase.repository.TeamPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamplayerService {
    @Autowired
    private TeamPlayerRepository teamplayerrepository;

    public void updateRuns(int playerId, int uptoruns) {
        this.teamplayerrepository.updateRuns(playerId,uptoruns);
    }

    public void updateWickets(int playerId) {
        System.out.println(playerId);
        int w =this.teamplayerrepository.findWickets(playerId);
        w++;
        this.teamplayerrepository.updateWickets(playerId,w);
    }

    public TeamPlayer findByIdAndMatchId(int id, int matchid) {
        return this.teamplayerrepository.findByIdAndMatchId(id,matchid);
    }
}
