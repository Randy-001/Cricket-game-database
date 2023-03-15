package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.TeamPlayer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TeamPlayerRepository extends MongoRepository<TeamPlayer,Integer> {


}
