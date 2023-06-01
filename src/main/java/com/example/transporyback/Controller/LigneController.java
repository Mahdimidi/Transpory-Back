package com.example.transporyback.Controller;

import com.example.transporyback.Model.Horaire;
import com.example.transporyback.Model.Ligne;
import com.example.transporyback.Model.Station;
import com.example.transporyback.Repository.LigneRepository;
import com.example.transporyback.Service.LigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ligne")
public class LigneController {
 @Autowired
    LigneRepository ligneRepository;
 @Autowired
    LigneService ligneService;

    @GetMapping(value = "/afficherLigne")
    public List<Ligne> getLigne(){
     return ligneService.getLigne();
       }

    @GetMapping(value = "/afficherLigne/{id}")
    public Optional<Ligne> findById(@PathVariable("id") int id){
        return ligneService.findById(id);}

    @PostMapping(value = "/ecrireLigne/{id}")
    public void addLigne(@RequestBody Ligne ligne ){
     ligneService.addLigne(ligne);
    }
/*

    public void updateLigne(@RequestBody Ligne ligne , @PathVariable int id){
        ligneService.updateLigne(id);
    }*/
    @PutMapping("/modifierLigne/{id}")
    public ResponseEntity<Ligne> updateLigne(@PathVariable("id") Long id, @RequestBody Ligne ligne) {
        Ligne L = ligneService.updateLigne(id, ligne);
        return ResponseEntity.ok(L);
    }

    @DeleteMapping("/deleteLigne/{id}")
    public void DeleteLigne(@PathVariable int id){
        ligneService.deleteLigne(id);
    }


}
