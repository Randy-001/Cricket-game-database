package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match,Integer> {


}
