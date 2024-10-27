package com.vedruna.trofeos.services;

import java.util.List;

import com.vedruna.trofeos.DTO.CreateTrophyDTO;
import com.vedruna.trofeos.DTO.TrophyDTO;

public interface TrophyServiceI {

    List<TrophyDTO> getAll();
    List<TrophyDTO> getByName(String title);
    TrophyDTO getById(int id);

    void save(CreateTrophyDTO createTrophyDTO);

    String test();
 
}
