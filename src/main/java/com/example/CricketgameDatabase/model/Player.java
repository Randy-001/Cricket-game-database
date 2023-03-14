package com.example.CricketgameDatabase.model;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @Column(updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @Column(updatable=false)
    private String playerName;
    @Column(updatable=false)
    private Boolean isBatsman;
    @Column(updatable=false)
    private Boolean isBowler;




    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Boolean getIsBatsman() {
        return isBatsman;
    }

    public void setIsBatsman(Boolean batsman) {
        isBatsman = batsman;
    }

    public Boolean getIsBowler() {
        return isBowler;
    }

    public void setIsBowler(Boolean bowler) {
        isBowler = bowler;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
