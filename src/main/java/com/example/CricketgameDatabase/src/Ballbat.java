package com.example.CricketgameDatabase.src;

import java.lang.Math;
public class Ballbat{
    Player batsman,bowler;
    int runs;
    boolean isWicket;
    public int random(){
        int r = (int) (Math.random()*8);
        if(r!=7)
        {
            this.runs=r;
            this.batsman.setRuns(r);
        }
        else{
            this.bowler.setWickets();
            this.isWicket=true;
        }
        return r;
    }

    public Player getBatsman() {
        return batsman;
    }

    public void setBatsman(Player batsman) {
        this.batsman = batsman;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }
}
