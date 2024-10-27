package com.vedruna.trofeos.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.trofeos.persistance.model.Player;

public interface PlayerRepositoryI extends JpaRepository<Player, Integer> {
    List<Player> findByName(String name);  
}
