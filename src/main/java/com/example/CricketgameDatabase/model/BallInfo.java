package com.example.CricketgameDatabase.model;

import javax.persistence.*;

@Entity

public class BallInfo {
    @Id
    @Column(updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ballId;
    @Column(updatable=false)
    private int ballNo;
    @Column(updatable=false)
    private int run;
    @Column(updatable=false)
    private int wicket;
    @OneToOne
    @JoinColumn
    private TeamPlayer batsman;
    @OneToOne
    @JoinColumn
    private TeamPlayer bowler;

    public int getBallNo() {
        return ballNo;
    }

    public void setBallNo(int ballNo) {
        this.ballNo = ballNo;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getWicket() {
        return wicket;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }


    public TeamPlayer getBatsman() {
        return batsman;
    }

    public void setBatsman(TeamPlayer batsman) {
        this.batsman = batsman;
    }

    public TeamPlayer getBowler() {
        return bowler;
    }

    public void setBowler(TeamPlayer bowler) {
        this.bowler = bowler;
    }

    public int getBallId() {
        return ballId;
    }

    public void setBallId(int ballId) {
        this.ballId = ballId;
    }
}
