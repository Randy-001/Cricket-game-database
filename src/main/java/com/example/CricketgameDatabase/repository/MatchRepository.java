package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.Match;
import com.example.CricketgameDatabase.model.Player;
import com.example.CricketgameDatabase.model.PlayingTeam;
import com.example.CricketgameDatabase.model.TeamPlayer;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends MongoRepository<Match,Integer> {

    @Aggregation(pipeline = {
            "{'$match':{'_id':?1}}",
            "{'$match':{'playingTeams.teamPlayer.player._id':?0}}",
            "{'$project': {'playingTeams': 1}}",





    })

    //@Query(value = "{'_id': ?1,'playingTeams.teamPlayer.player._id': ?0}",fields = "{'playingTeams.teamPlayer': 1}")
    Match findPlayer(int playerId, int matchId);
}
