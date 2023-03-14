package com.example.CricketgameDatabase.repository;

import com.example.CricketgameDatabase.model.Innings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InningsRepository extends JpaRepository<Innings,Integer> {
}
