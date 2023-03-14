package com.example.CricketgameDatabase.src;

import java.util.ArrayList;

public class Innings {
    ArrayList<Overs> oversinfo = new ArrayList<Overs>();
    int runs;
    int wickets;
    String teamName;

    public void playing(Team teamOne,Team teamTwo,boolean batFirst){
        this.teamName=teamOne.teamName;
        for(int i=0;i<Match.overs&&this.wickets<10;i++)
        {
            this.oversinfo.add(new Overs());
            for(int j=0;j<6&&this.wickets<10;j++)
            {
                this.oversinfo.get(i).ballInfo.add(new Ballbat());
                this.oversinfo.get(i).ballInfo.get(j).setBatsman(teamOne.getBatsman());
                this.oversinfo.get(i).ballInfo.get(j).setBowler(teamTwo.getBowler());
                int r=this.oversinfo.get(i).ballInfo.get(j).random();
                if(r==7){
                    wickets++;
                    teamOne.nextBatsman();
                }
                else{
                    this.runs=this.runs+r;
                }

                if(!batFirst && this.runs>Match.target) break;

            }
            teamTwo.nextBowler();
            if(!batFirst && this.runs>Match.target) break;
        }
    }

}
