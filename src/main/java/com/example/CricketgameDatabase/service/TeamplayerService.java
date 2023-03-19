package com.example.CricketgameDatabase.service;

import com.example.CricketgameDatabase.model.*;
import com.example.CricketgameDatabase.repository.MatchRepository;
import com.example.CricketgameDatabase.repository.TeamPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamplayerService {
    @Autowired
    private MatchRepository matchRepository;

    public PlayerIdentity findByIdAndMatchId(int playerId, int matchId) {
        PlayerIdentity m = this.matchRepository.findPlayer(playerId,matchId);
        return m;
    }
}
