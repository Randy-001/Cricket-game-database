package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.PlayingTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayingTeamRepository extends JpaRepository<PlayingTeam,Integer> {
    @Query(value = "select * from playing_team  where match_id=?1 and playing_team_id!=?2",nativeQuery = true)
    PlayingTeam findBowlingTeam(int matchId, int batting);


}
