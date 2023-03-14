package com.example.CricketgameDatabase.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Overs {
    @Id
    @Column(updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oversId;
    @Column(updatable=false)
    private int oversNo;
    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn
    private List<BallInfo> balls;

    public int getOversNo() {
        return oversNo;
    }

    public List<BallInfo> getBalls() {
        return balls;
    }

    public void setBalls(List<BallInfo> balls) {
        this.balls = balls;
    }

    public void setOversNo(int oversNo) {
        this.oversNo = oversNo;
    }

    public int getOversId() {
        return oversId;
    }

    public void setOversId(int oversId) {
        this.oversId = oversId;
    }
}
