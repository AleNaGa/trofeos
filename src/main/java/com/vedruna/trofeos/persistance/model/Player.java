package com.vedruna.trofeos.persistance.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idplayer")
    private int id;

    @Column(name="username")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "players_has_trophies",
        joinColumns = @JoinColumn(name = "players_idplayer"),
        inverseJoinColumns = @JoinColumn(name = "trophies_idtrophie")
    )
    private List<Trophy> trophiesOfPlayer = new ArrayList<>();
    
}
