package com.vedruna.trofeos.services;

import java.util.List;

import com.vedruna.trofeos.DTO.CreatePlayerDTO;
import com.vedruna.trofeos.DTO.PlayerDTO;

public interface PlayerServiceI {

    public List<PlayerDTO> getAll();
    public List<PlayerDTO> getByName(String name);
    public PlayerDTO getById(int id);
    public void save(CreatePlayerDTO createPlayerDTO);
    public void giveTrophyToPlayer(int idPlayer, int idTrophy);
    public void delete(int id);


    public String test();
}
