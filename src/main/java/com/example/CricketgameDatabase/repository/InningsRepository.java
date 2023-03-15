package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.Innings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InningsRepository extends MongoRepository<Innings,Integer> {
}
