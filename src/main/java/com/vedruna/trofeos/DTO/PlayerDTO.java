package com.vedruna.trofeos.DTO;

import java.util.List;

import com.vedruna.trofeos.persistance.model.Player;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerDTO { // Para mostrar

    private int id;
    private String name;
    private List<TrophyDTO> trophiesOfPlayer;

    public PlayerDTO(Player player){
        this.id = player.getId();
        this.name = player.getName();
        this.trophiesOfPlayer = player.getTrophiesOfPlayer().stream().map(TrophyDTO::new).toList();
    }    
}
