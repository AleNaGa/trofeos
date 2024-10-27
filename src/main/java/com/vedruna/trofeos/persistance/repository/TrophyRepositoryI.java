package com.vedruna.trofeos.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.trofeos.persistance.model.Trophy;

public interface TrophyRepositoryI extends JpaRepository<Trophy, Integer> {
    List<Trophy> findByTitle(String title);  
}