package com.vedruna.trofeos.DTO;

import java.util.ArrayList;
import java.util.List;

import com.vedruna.trofeos.persistance.model.Player;
import com.vedruna.trofeos.persistance.model.Trophy;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTrophyDTO {
    
    private int id;
    private String title;
    private String description;
    private List<Player> playersWhoHaveTrophy;

    public CreateTrophyDTO(Trophy trophy) {
        this.id = trophy.getId();
        this.title = trophy.getTitle();
        this.description = trophy.getDescription();
        this.playersWhoHaveTrophy = new ArrayList<>();
    }
}
