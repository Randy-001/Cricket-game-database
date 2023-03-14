package com.example.CricketgameDatabase.src;

import java.util.ArrayList;

public class Team {
    String teamName;
    ArrayList<Player> playerList = new ArrayList<>();
    int no;
    int bowlerNo=6;
    public Team(String teamName) {
        this.teamName = teamName;
    }
    public void addPlayers(){
        for(int i=0;i<6;i++){
            this.playerList.add(new Player("Rohit",34,i));
            this.playerList.get(i).setBatsman(true);
        }
        for(int i=6;i<11;i++){
            this.playerList.add(new Player("Bumrah",34,i));
            this.playerList.get(i).setBowler(true);
        }


    }
    public Player getBatsman()
    {
        return playerList.get(this.no);
    }
    public void nextBatsman()
    {
        this.no++;
    }
    public Player getBowler()
    {
        return playerList.get(6+(this.bowlerNo%6));
    }
    public void nextBowler()
    {
        this.bowlerNo++;
    }







}
