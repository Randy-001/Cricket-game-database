package com.example.CricketgameDatabase.service;

import com.example.CricketgameDatabase.model.Match;
import com.example.CricketgameDatabase.model.PlayingTeam;
import com.example.CricketgameDatabase.model.Team;
import com.example.CricketgameDatabase.model.TeamPlayer;
import com.example.CricketgameDatabase.repository.MatchRepository;
import com.example.CricketgameDatabase.repository.TeamPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamplayerService {
    @Autowired
    private MatchRepository matchRepository;

    public TeamPlayer findByIdAndMatchId(int playerId, int matchId) {
        Match m = this.matchRepository.findPlayer(playerId,matchId);
        System.out.println(m);
        for(PlayingTeam p : m.getPlayingTeams())
        {
            for(TeamPlayer t : p.getTeamPlayer())
            {
                if(t.getPlayer().getPlayerId()==playerId)
                {
                    return t;
                }
            }
        }

        return null;
    }
}
