package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

}
