package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.PlayingTeam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayingTeamRepository extends MongoRepository<PlayingTeam,Integer> {

}
