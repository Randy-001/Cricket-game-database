package com.example.CricketgameDatabase.model;

import javax.persistence.*;

@Entity
public class Scoreboard {
    @Id
    @Column(updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scoreboardId;

    @OneToOne
    private PlayingTeam winner;

    @Column(updatable=false)
    private int target;
    @Column(updatable=false)
    private boolean isDraw;

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }

    public int getScoreboardId() {
        return scoreboardId;
    }

    public void setScoreboardId(int scoreboardId) {
        this.scoreboardId = scoreboardId;
    }

    public PlayingTeam getWinner() {
        return winner;
    }

    public void setWinner(PlayingTeam winner) {
        this.winner = winner;
    }
}
