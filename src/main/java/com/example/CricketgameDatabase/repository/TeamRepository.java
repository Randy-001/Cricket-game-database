package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team,Integer> {

}
