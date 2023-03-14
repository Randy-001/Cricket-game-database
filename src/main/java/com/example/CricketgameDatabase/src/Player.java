package com.example.CricketgameDatabase.src;

public class Player {
    String name;
    int age,id;
    boolean isBowler,isBatsman,isAllRounder;
    int runs,wickets;
     public Player(String name, int age, int id){
        this.name = name;
        this.age=age;
        this.id=id;
    }

    public void setBowler(boolean bowler) {
        isBowler = bowler;
    }

    public void setBatsman(boolean batsman) {
        isBatsman = batsman;
    }

    public void setAllRounder(boolean allRounder) {
        isAllRounder = allRounder;
    }

    public void setRuns(int runs) {
        this.runs = this.runs+runs;
    }

    public void setWickets() {
        this.wickets++;
    }
}
