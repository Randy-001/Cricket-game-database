package com.example.CricketgameDatabase.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @Column(updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
    @Column(updatable=false)
    private String teamName;
    @Column(updatable=false)
    private String coachName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="teamId")
    private List<Player> players;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }



    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

}
