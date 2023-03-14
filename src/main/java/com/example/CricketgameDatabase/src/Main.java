package com.example.CricketgameDatabase.src;

import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {



        String teamA,teamB;
        System.out.println("Enter the overs");
        Scanner sc= new Scanner(System.in);
        int overs = sc.nextInt();
        Match.overs=overs;
        System.out.println("Enter the Team-1 name");
        teamA=sc.next();
        System.out.println("Enter the Team-2 name");
        teamB=sc.next();
        Match m = new Match();
        m.createTeam(teamA,teamB);
        int toss = (int)(Math.random()*2);
        //assuming team1 chooses 1
        //assuminmg team2 chooses 0
        System.out.println(toss==0?teamB+" chooses to bat!":teamA+" chooses to bat!");
        m.startGame(toss);
        m.winner();
        m.ScoreBoard();

    }
}
