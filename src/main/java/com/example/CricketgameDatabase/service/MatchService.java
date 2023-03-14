package com.example.CricketgameDatabase.service;

import com.example.CricketgameDatabase.model.*;
import com.example.CricketgameDatabase.repository.MatchRepository;
import com.example.CricketgameDatabase.repository.PlayingTeamRepository;
import com.example.CricketgameDatabase.repository.TeamPlayerRepository;
import com.example.CricketgameDatabase.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    private MatchRepository matchrepository;
    private TeamRepository teamrepository;
    private InningsService inningsservice;
    private PlayingTeamRepository playingteamrepository;
    private TeamPlayerRepository teamplayerrepository;

    @Autowired
    public MatchService(MatchRepository matchrepository, TeamRepository teamrepository, InningsService inningsservice, PlayingTeamRepository playingteamrepository, TeamPlayerRepository teamplayerrepository) {
        this.matchrepository = matchrepository;
        this.teamrepository = teamrepository;
        this.inningsservice=inningsservice;
        this.playingteamrepository=playingteamrepository;
        this.teamplayerrepository=teamplayerrepository;
    }

    public Match add(Match match) {
        int count=(int) this.matchrepository.count();
        count++;
        List<PlayingTeam> pl = new ArrayList<>();
        for(int i=0;i<2;i++)
        {
            pl.add(new PlayingTeam());
            System.out.println("Team "+i+"   "+match.getTeams().get(i).getTeamId());
            pl.get(i).setTeam(this.teamrepository.findById(match.getTeams().get(i).getTeamId()).get());
            List<TeamPlayer> tp = new ArrayList<>();
            List<Player> p = this.teamrepository.findById(match.getTeams().get(i).getTeamId()).get().getPlayers();
            for(int j=0;j<11;j++)
            {
                tp.add(new TeamPlayer());
                tp.get(j).setMatchId(count);
                tp.get(j).setPlayer(p.get(j));
            }
            pl.get(i).setTeamPlayer(tp);
        }
        match.setMatchId(count);
        match.setPlayingTeams(pl);
        return this.matchrepository.save(match);

    }

    public List<Match> get() {
        return this.matchrepository.findAll();
    }



    public String toss(int id) {
        Match m = this.matchrepository.findById(id).orElse(null);

            int toss = (int)(Math.random()*2);
            if(toss==0)
            {
                m.setBatting(m.getPlayingTeams().get(0).getPlayingTeamId());
                this.matchrepository.save(m);
                return "Bat First : "+m.getTeams().get(0).getTeamName();
            }
            else{
                m.setBatting(m.getPlayingTeams().get(0).getPlayingTeamId());
                this.matchrepository.save(m);
                return "Bat First : "+m.getTeams().get(1).getTeamName();
            }


    }

    public Match startGame(int id) {
        Match m=this.matchrepository.findById(id).orElse(null);
        PlayingTeam teamA=this.playingteamrepository.findById(m.getBatting()).orElse(null);
        PlayingTeam teamB=this.playingteamrepository.findBowlingTeam(m.getMatchId(),m.getBatting());
        ArrayList<Innings> i = new ArrayList<>();
        boolean b= true;
        int target=0;
        for(int j=0;j<2;j++)
        {
            i.add(new Innings());
            i.get(j).setInningsNo(j+1);
            i.get(j).setOvers(new ArrayList<Overs>());
            i.set(j,this.inningsservice.play(teamA,teamB,i.get(j),m,b,target));
            b=false;
            target=i.get(j).getRuns();
            PlayingTeam temp=teamA;
            teamA=teamB;
            teamB=temp;

        }
        System.out.println("Come on ..................................");
        m.setScoreBoard(determineWinner(i,teamA,teamB));
        m.setInnings(i);
        return this.matchrepository.save(m);
    }

    public Scoreboard determineWinner(List<Innings> innings, PlayingTeam teamA, PlayingTeam teamB)
    {
        Scoreboard sc = new Scoreboard();
        sc.setTarget(innings.get(0).getRuns());
        if(innings.get(0).getRuns()>innings.get(1).getRuns())
        {
            sc.setWinner(teamA);
        }
        else if(innings.get(1).getRuns()>innings.get(0).getRuns())
        {
            sc.setWinner(teamB);
        }
        else{
            sc.setDraw(true);
        }
        return sc;
    }

    public Match getmatchbyid(int id) {
        return this.matchrepository.findById(id).orElse(null);
    }
}
