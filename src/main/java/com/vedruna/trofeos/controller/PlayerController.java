package com.vedruna.trofeos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.trofeos.DTO.CreatePlayerDTO;
import com.vedruna.trofeos.DTO.PlayerDTO;
import com.vedruna.trofeos.services.PlayerServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
    @Autowired
    private PlayerServiceI playerServ;

    @GetMapping("/test")
    public String test() {
        return playerServ.test();
    }

    @GetMapping 
    public List<PlayerDTO> getAll() {
        try{
            return playerServ.getAll();
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @GetMapping("/nombre/{nombre}")
    public List<PlayerDTO> getByName(@PathVariable String nombre) {
        try{
            return playerServ.getByName(nombre);
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/id/{id}")
    public PlayerDTO getById(@PathVariable int id) {
        try{
            return playerServ.getById(id);
        }catch(Exception e){
            e.printStackTrace();
            return new PlayerDTO();
        }
    }

    @PutMapping("/darTrofeo/jugador/{id}/trofeo/{trophyId}")
    public String giveTrophyToPlayer(@PathVariable int id, @PathVariable int trophyId) {
        try{
            playerServ.giveTrophyToPlayer(id, trophyId);
            return "Saved";
        }catch(Exception e){
            return e.getMessage();
        }
    }



    @PostMapping("/insert")
    public String save(@RequestBody CreatePlayerDTO createPlayerDTO) {
        try{
            playerServ.save(createPlayerDTO);
            return "Saved";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        try{
            playerServ.delete(id);
            return "Deleted";
        }catch(Exception e){
            return e.getMessage();
        }
    }  
}
