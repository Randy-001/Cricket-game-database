package com.example.CricketgameDatabase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class TeamPlayer {
    @Id
    @Column(updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamPlayerId;
    @ManyToOne
    @JoinColumn
    private Player player;
    private int runs;
    private int wickets;


    @Column(name="matchId")
    private int matchId;

    @ManyToOne
    @JoinColumn(name="teamPlayer_playing_team_id")
    private PlayingTeam playingTeam;



    //@JsonIgnore
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getTeamPlayerId() {
        return teamPlayerId;
    }

    public void setTeamPlayerId(int teamPlayerId) {
        this.teamPlayerId = teamPlayerId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @JsonBackReference
    public PlayingTeam getPlayingTeam() {
        return playingTeam;
    }

    public void setPlayingTeam(PlayingTeam playingTeam) {
        this.playingTeam = playingTeam;
    }
}
