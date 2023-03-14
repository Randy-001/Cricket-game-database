package com.example.CricketgameDatabase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlayingTeam {
    @Id
    @Column(updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int playingTeamId;


    @ManyToOne
    @JoinColumn(name="teamId")
    private Team team;

  @OneToMany(cascade = CascadeType.ALL,mappedBy = "playingTeam")
  private List<TeamPlayer> teamPlayer;


    public int getPlayingTeamId() {
        return playingTeamId;
    }

    public void setPlayingTeamId(int playingTeamId) {
        this.playingTeamId = playingTeamId;
    }


    @JsonBackReference
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @JsonManagedReference
    public List<TeamPlayer> getTeamPlayer() {
        return teamPlayer;
    }

    public void setTeamPlayer(List<TeamPlayer> teamPlayer) {

        this.teamPlayer = teamPlayer;
        for(TeamPlayer t : teamPlayer)
        {
            t.setPlayingTeam(this);
        }
    }

}
