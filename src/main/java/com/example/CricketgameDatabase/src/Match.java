package com.example.CricketgameDatabase.src;

public class Match {
    static int overs;
    private Team teamA;
    private Team teamB;
    private Innings inningsOne = new Innings(),inningsTwo = new Innings();
    static int target;
    public void createTeam(String teamA,String teamB){
        this.teamA=new Team(teamA);
        this.teamA.addPlayers();
        this.teamB=new Team(teamB);
        this.teamB.addPlayers();

    }
    public void startGame(int toss)
    {

        if(toss==0)
        {
            this.inningsOne.playing(this.teamB,this.teamA,true);
            Match.target=this.inningsOne.runs;
            this.inningsTwo.playing(this.teamA,this.teamB,false);

        }
        else{
            this.inningsOne.playing(this.teamA,this.teamB,true);
            Match.target=this.inningsOne.runs;
            this.inningsTwo.playing(this.teamB,this.teamA,false);
        }

    }
    public void winner()
    {
        System.out.println(this.inningsOne.teamName+" runs : "+this.inningsOne.runs+"-"+this.inningsOne.wickets+" "+this.inningsTwo.teamName+" runs : "+this.inningsTwo.runs+"-"+this.inningsTwo.wickets);
        if(this.inningsOne.runs>this.inningsTwo.runs)
        {
            System.out.println(this.inningsOne.teamName+ " won the match");
        }
        else if(this.inningsTwo.runs>this.inningsOne.runs)
        {
            System.out.println(this.inningsTwo.teamName+ " won the match");
        }
        else{
            System.out.println("Match Draw.....");
        }
    }
    public void ScoreBoard()
    {
        System.out.println("Team Name : "+this.inningsOne.teamName);
        System.out.println("Player name\tRuns\tWickets");
        for(Player i : this.teamA.playerList)
        {
            System.out.println(i.name+"\t"+i.runs+"\t"+i.wickets);
        }
        System.out.println("Team Name : "+this.inningsTwo.teamName);
        System.out.println("Player name\tRuns\tWickets");
        for(Player i : this.teamB.playerList)
        {
            System.out.println(i.name+"\t"+i.runs+"\t"+i.wickets);
        }
    }



    }




