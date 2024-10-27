package com.vedruna.trofeos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vedruna.trofeos.DTO.CreateTrophyDTO;
import com.vedruna.trofeos.DTO.TrophyDTO;
import com.vedruna.trofeos.persistance.model.Trophy;
import com.vedruna.trofeos.persistance.repository.TrophyRepositoryI;

public class TrophyServiceImpl implements TrophyServiceI {

    @Autowired
    TrophyRepositoryI trophyRepo;
    @Override
    public List<TrophyDTO> getAll() {
        return trophyRepo.findAll().stream().map(TrophyDTO::new).toList();
    }

    @Override
    public List<TrophyDTO> getByName(String title) {
        return trophyRepo.findByTitle(title).stream().map(TrophyDTO::new).toList();
    }

    @Override
    public TrophyDTO getById(int id) {
       return new TrophyDTO(trophyRepo.findById(id).get());
    }

    @Override
    public void save(CreateTrophyDTO createTrophyDTO) {
        Trophy newTrophy = new Trophy();
        newTrophy.setTitle(createTrophyDTO.getTitle());
        newTrophy.setDescription(createTrophyDTO.getDescription());
        newTrophy.setPlayersWhoHaveTrophy(createTrophyDTO.getPlayersWhoHaveTrophy());
        trophyRepo.save(newTrophy);
    }

    @Override
    public String test(){
        return "HelloWorld";
    }

    
}
