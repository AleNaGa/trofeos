package com.vedruna.trofeos.DTO;

import com.vedruna.trofeos.persistance.model.Trophy;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrophyDTO {

    private int id;
    private String title;
    private String description;

    public TrophyDTO(Trophy trophy) {
        this.id = trophy.getId();
        this.title = trophy.getTitle();
        this.description = trophy.getDescription();
    }
    
}
