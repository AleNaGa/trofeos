package com.vedruna.trofeos.DTO;

import java.util.ArrayList;
import java.util.List;

import com.vedruna.trofeos.persistance.model.Player;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreatePlayerDTO { // para crear con lista de trofeos vacía
    private int id;
    private String name;
    private List<TrophyDTO> trophiesOfPlayer;

    public CreatePlayerDTO(Player player){
        this.id = player.getId();
        this.name = player.getName();
        this.trophiesOfPlayer = new ArrayList<>();
    }
}
