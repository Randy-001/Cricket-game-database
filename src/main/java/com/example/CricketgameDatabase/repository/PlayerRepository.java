package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends MongoRepository<Player,Integer> {

}
