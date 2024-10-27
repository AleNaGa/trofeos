package com.vedruna.trofeos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.trofeos.DTO.CreateTrophyDTO;
import com.vedruna.trofeos.DTO.TrophyDTO;
import com.vedruna.trofeos.services.TrophyServiceI;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/trophies")
public class TrohpyController {

    @Autowired
    private TrophyServiceI trophyServ;

    @GetMapping("/test")
    public String test() {
        return trophyServ.test();
    }

    @GetMapping 
    public List<TrophyDTO> getAll() {
        try{
            return trophyServ.getAll();
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("title/{title}")
    public List<TrophyDTO> getByName(@PathVariable String title) {
        try{
            return trophyServ.getByName(title);
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @GetMapping("/id/{id}")
    public TrophyDTO getById(@PathVariable int id) {
        try{
            return trophyServ.getById(id);
        }catch(Exception e){
            e.printStackTrace();
            return new TrophyDTO();
        }
    }

    @PostMapping("/insert")
    public String save(@RequestBody CreateTrophyDTO trophyDTO) {
        try{
            trophyServ.save(trophyDTO);
            return "Saved";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    
}
