package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

}
