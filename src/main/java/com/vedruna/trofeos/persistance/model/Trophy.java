package com.vedruna.trofeos.persistance.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "trophies")
public class Trophy {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idtrophie")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy="trophiesOfPlayer")
    private List<Player> playersWhoHaveTrophy = new ArrayList<>();
    
}
