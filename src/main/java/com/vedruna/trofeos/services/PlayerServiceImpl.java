package com.vedruna.trofeos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.trofeos.DTO.CreatePlayerDTO;
import com.vedruna.trofeos.DTO.PlayerDTO;
import com.vedruna.trofeos.persistance.model.Player;
import com.vedruna.trofeos.persistance.repository.PlayerRepositoryI;
import com.vedruna.trofeos.persistance.repository.TrophyRepositoryI;


@Service
public class PlayerServiceImpl implements PlayerServiceI{


    @Autowired
    PlayerRepositoryI playerRepo;
    @Autowired
    TrophyRepositoryI trophyRepo;
    @Override
    public List<PlayerDTO> getAll() {
      return playerRepo.findAll().stream().map(PlayerDTO::new).toList();
    }

    @Override
    public List<PlayerDTO> getByName(String name) {
       return playerRepo.findByName(name).stream().map(PlayerDTO::new).toList();
    }

    @Override
    public PlayerDTO getById(int id) {
        return new PlayerDTO(playerRepo.findById(id).get());
    }

    @Override
    public void save(CreatePlayerDTO createPlayerDTO) {
       Player newPlayer = new Player();
       newPlayer.setName(createPlayerDTO.getName());
       newPlayer.setTrophiesOfPlayer(new ArrayList<>());
       playerRepo.save(newPlayer);
    }

    @Override
    public void giveTrophyToPlayer(int idPlayer, int idTrophy) {
        Player player = playerRepo.findById(idPlayer).get();
        player.getTrophiesOfPlayer().add(trophyRepo.findById(idTrophy).get());
        playerRepo.save(player);
    }

    @Override
    public void delete(int id) {
        playerRepo.delete(playerRepo.findById(id).get());
    }



    @Override
    public String test(){
        return "HelloWorld";
    }
    
}
