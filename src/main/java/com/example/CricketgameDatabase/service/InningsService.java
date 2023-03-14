package com.example.CricketgameDatabase.service;

import com.example.CricketgameDatabase.model.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InningsService {
    private TeamplayerService teamplayerservice;
    @Autowired
    public InningsService(TeamplayerService teamplayerservice) {
        this.teamplayerservice = teamplayerservice;
    }

    public Innings play(PlayingTeam teamA, PlayingTeam teamB, Innings innings, com.example.CricketgameDatabase.model.Match m, boolean batFirst, int target) {
        List<Overs> oversInfo = innings.getOvers();
        int uptoRuns=0;
        int g=0,h=0;
        for(int i = 0; i< m.getOvers()&&innings.getWickets()<10; i++)
        {
            oversInfo.add(new Overs());
            ArrayList<BallInfo> ballInfo = new ArrayList<>();
            for(int j=0;j<6&&innings.getWickets()<10;j++)
            {
                ballInfo.add(new BallInfo());
                ballInfo.get(j).setBatsman(teamA.getTeamPlayer().get(h));
                ballInfo.get(j).setBowler(teamB.getTeamPlayer().get(5+(i%6)));
                ballInfo.get(j).setBallNo(j+1);
                int r = (int) (Math.random()*8);
                if(r==7){
                    h++;
                    ballInfo.get(j).setWicket(1);
                    this.teamplayerservice.updateRuns(ballInfo.get(j).getBatsman().getTeamPlayerId(),uptoRuns);
                    this.teamplayerservice.updateWickets(ballInfo.get(j).getBowler().getTeamPlayerId());
                    uptoRuns=0;
                }
                else{
                    g+=r;
                    uptoRuns+=r;
                    ballInfo.get(j).setRun(r);

                }


                               if(!batFirst && g>target) break;
            }
            oversInfo.get(i).setBalls(ballInfo);
            oversInfo.get(i).setOversNo(i+1);
            if(!batFirst && g>target) break;
        }
        this.teamplayerservice.updateRuns(teamA.getTeamPlayer().get(h).getTeamPlayerId(),uptoRuns);
        innings.setRuns(g);
        innings.setWickets(h);
        innings.setOvers(oversInfo);
        return innings;
    }
}
