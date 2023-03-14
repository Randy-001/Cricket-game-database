package com.example.CricketgameDatabase.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Innings {
    @Id
    @Column(updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inningsId;

    @Column(updatable=false)
    private int inningsNo;
    @Column(updatable=false)
    private int runs;
    @Column(updatable=false)
    private int wickets;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="inningsId")
    private List<Overs> overs;
    public int getInningsNo() {
        return inningsNo;
    }

    public void setInningsNo(int inningsNo) {
        this.inningsNo = inningsNo;
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

    public List<Overs> getOvers() {
        return overs;
    }

    public void setOvers(List<Overs> overs) {
        this.overs = overs;
    }

    public int getInningsId() {
        return inningsId;
    }

    public void setInningsId(int inningsId) {
        this.inningsId = inningsId;
    }



    @Override
    public String toString() {
        return "Innings{" +
                "inningsId=" + inningsId +
                ", inningsNo=" + inningsNo +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", overs=" + overs +
                '}';
    }
}
