package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TeamPlayerRepository extends JpaRepository<TeamPlayer,Integer> {
    @Modifying
    @Transactional
    @Query("update  TeamPlayer set runs=?2 where team_player_id=?1")
    void updateRuns(int id, int runs);

    @Modifying
    @Transactional
    @Query("update TeamPlayer set wickets=?2 where team_player_id=?1")
    void updateWickets(int id,int wickets);

    @Query("select wickets from TeamPlayer where team_player_id=?1")
    int findWickets(int id);

    @Modifying
    @Transactional
    @Query("update TeamPlayer set matchId=?1 where team_player_id=?2")
    void updateMatchId(int matchId, int teamPlayerId);

    @Query("from TeamPlayer where player_player_id=?1 and matchId=?2")
    TeamPlayer findByIdAndMatchId(int id, int matchId);
}
